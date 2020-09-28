package com.lucifer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lucifer.dao.AppealDao;
import com.lucifer.dao.BusinessServiceDao;
import com.lucifer.dao.CityDao;
import com.lucifer.dao.JobDao;
import com.lucifer.dao.ResumeDao;
import com.lucifer.dao.UserDao;
import com.lucifer.model.Appeal;

import com.lucifer.model.BusinessService;
import com.lucifer.model.City;
import com.lucifer.model.Company;
import com.lucifer.model.Job;
import com.lucifer.model.Resume;
import com.lucifer.model.User;
import com.lucifer.util.StringUtil;



@Service
public class SearchService {

	private static Log log = LogFactory.getLog(SearchService.class);

	@Value("${solr_resume_url}")
	private String solr_resume_url;

	@Value("${solr_job_url}")
	private String solr_job_url;

	@Value("${solr_service_url}")
	private String solr_service_url;

	@Value("${solr_appeal_url}")
	private String solr_appeal_url;

	private HttpSolrServer resume_server;

	private HttpSolrServer job_server;

	private HttpSolrServer service_server;

	private HttpSolrServer appeal_server;

	@Resource
	private ResumeDao resumeDao;

	@Resource
	private JobDao recruitmentDao;

	@Resource
	private BusinessServiceDao businessServiceDao;

	@Resource
	private AppealDao appealDao;

	@Resource
	private UserDao userDao;

	@Resource
	private CityDao cityDao;

	@PostConstruct
	public void init() throws Exception {
		try {
			resume_server = new HttpSolrServer(solr_resume_url);
			job_server = new HttpSolrServer(solr_job_url);
			service_server = new HttpSolrServer(solr_service_url);
			appeal_server = new HttpSolrServer(solr_appeal_url);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SolrService init failed" + e.getMessage());
		}
		new Thread(new Db2Solr()).start();
	}

	class Db2Solr implements Runnable {
		/**
		 * 数据库数据导入solr
		 *
		 * @throws Exception
		 */
		public void db2Solr() throws Exception {
			while (true) {
				resumeImport();
				jobImport();
				serviceImport();
				appealImport();
				Thread.sleep(10000);
			}
		}


		@Override
		public void run() {
			try {
				db2Solr();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("db2solr error:" + e.getMessage());
			}
		}
	}

	/**
	 * 清空solr
	 *
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public void clearSolr() throws SolrServerException, IOException {
		resume_server.deleteByQuery("*:*");
		resume_server.commit();
		job_server.deleteByQuery("*:*");
		job_server.commit();
		service_server.deleteByQuery("*:*");
		service_server.commit();
		appeal_server.deleteByQuery("*:*");
		appeal_server.commit();
	}

	/**
	 * 简历toDocument
	 * @param resume
	 * @return
	 */
	private SolrInputDocument resumeSolrDocument(Resume resume) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", resume.getId());
		doc.addField("city_id", resume.getCity_id());
		doc.addField("industry_id", resume.getIndustry_id());
		doc.addField("position_id", resume.getPosition_id());
		doc.addField("evaluation", resume.getEvaluation());
		doc.addField("title", resume.getTitle());
		doc.addField("start_work_date", resume.getStart_work_date());
		doc.addField("updated_at", resume.getUpdated_at());
		doc.addField("open", resume.getOpen());
		return doc;
	}

	/**
	 * 职位 to Document
	 * @param job
	 * @return
	 */
	private SolrInputDocument jobSolrDocument(Job job) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", job.getId());
		doc.addField("city_id", job.getCity_id());
		doc.addField("industry_id", job.getIndustry_id());
		doc.addField("position_id", job.getPosition_id());
		doc.addField("evaluation", job.getEducation());
		doc.addField("title", job.getTitle());
		doc.addField("work_years", job.getWork_years());
		doc.addField("updated_at", job.getUpdated_at());
		return doc;
	}

	private SolrInputDocument serviceSolrDocument(BusinessService service) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", service.getId());
		doc.addField("city_id", service.getCity_id());

		//doc.addField("title", service.getTitle());
		doc.addField("type_b", service.getType_b() );
		doc.addField("type_s", service.getType_s());
		doc.addField("updated_at", service.getUpdated_at());
		return doc;
	}

	private SolrInputDocument appealSolrDocument(Appeal appeal) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", appeal.getId());
		doc.addField("city_id", appeal.getCity_id());

		doc.addField("title", appeal.getTitle());
		doc.addField("type", appeal.getType());
		doc.addField("updated_at", appeal.getUpdated_at());
		return doc;
	}



	/**
	 * 简历导入
	 *
	 * @throws Exception
	 */
	private void resumeImport() throws Exception {
		log.info("resumeImport has been called");
		Date updated_at = null;
		while (true) {
			// 如果没有更新查询SOLR中是否有数据
			if (updated_at == null) {
				SolrQuery query = new SolrQuery();
				query.setQuery("*:*");
				query.addSort("updated_at", SolrQuery.ORDER.desc);
				query.setRows(1);
				QueryResponse rsp = resume_server.query(query);
				SolrDocumentList docs = rsp.getResults();
				log.info(docs.size());
				if (docs.size() > 0) {
					SolrDocument resultDoc = docs.get(0);
					updated_at = (Date) resultDoc
							.getFieldValue("updated_at");
					log.info("updated_at:" + updated_at);
					// updated_at=new Date(updated_at.getTime());
					log.info("solar back updated_at is: " + updated_at);
				}
			}

			List<Resume> resumeList = null ;
			if (updated_at == null) {
				// solr中无数据直接从数据库取数据
				resumeList = resumeDao.resumeListOrderByUpdatedAt(updated_at, 1000);
			} else {
				// 如果有SOLR中有数据从数据库取比SOLR中时间晚的
				resumeList =  resumeDao.resumeListOrderByUpdatedAt(updated_at, 1000);
			}

			log.info("resumeList size: " + resumeList.size());

			if (resumeList.size() == 0) {
				break;
			}
			Collection<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
			List<String> deleteIdList = new ArrayList<String>();
			for (Resume resume : resumeList) {
				if (resume.getId() == 0.2) {
					deleteIdList.add(resume.getId().toString());
					continue;
				} else {
					SolrInputDocument doc1 = resumeSolrDocument(resume);
					docList.add(doc1);
				}
			}

			updated_at = resumeList.get(resumeList.size() - 1).getUpdated_at();
			System.out.println("new updated_at:" + updated_at);
			if (docList.size() > 0) {
				resume_server.add(docList);
			}
			if (deleteIdList.size() > 0) {
				resume_server.deleteById(deleteIdList);
			}
			resume_server.commit();
			log.info("resume_server.commit()");
		}
	}


	/**
	 * 工作导入
	 *
	 * @throws Exception
	 */
	private void jobImport() throws Exception {
		log.info("--jobImport has been called---");
		Date updated_at = null;
		while (true) {
			// 如果没有更新查询SOLR中是否有数据
			if (updated_at == null) {
				SolrQuery query = new SolrQuery();
				query.setQuery("*:*");
				query.addSort("updated_at", SolrQuery.ORDER.desc);
				query.setRows(1);
				QueryResponse rsp = job_server.query(query);
				SolrDocumentList docs = rsp.getResults();
				log.info(docs.size());
				if (docs.size() > 0) {
					SolrDocument resultDoc = docs.get(0);
					updated_at = (Date) resultDoc
							.getFieldValue("updated_at");
					log.info("updated_at:" + updated_at);
					// updated_at=new Date(updated_at.getTime());
					log.info("solar back updated_at is: " + updated_at);
				}
			}

			List<Job> jobList = null;
			if (updated_at == null) {
				// solr中无数据直接从数据库取数据
				jobList = recruitmentDao.jobListOrderByUpdatedAt(updated_at, 1000);
			} else {
				// 如果有SOLR中有数据从数据库取比SOLR中时间晚的
				jobList =  recruitmentDao.jobListOrderByUpdatedAt(updated_at, 1000);
			}

			log.info("joblist size: " + jobList.size());

			if (jobList.size() == 0) {
				break;
			}
			Collection<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
			List<String> deleteIdList = new ArrayList<String>();
			for (Job job : jobList) {
				if (job.getId() == 0.2) {
					deleteIdList.add(job.getId().toString());
					continue;
				} else {
					SolrInputDocument doc1 = jobSolrDocument(job);
					docList.add(doc1);
				}
			}

			updated_at = jobList.get(jobList.size() - 1).getUpdated_at();
			System.out.println("new updated_at:" + updated_at);
			if (docList.size() > 0) {
				job_server.add(docList);
			}
			if (deleteIdList.size() > 0) {
				job_server.deleteById(deleteIdList);
			}
			job_server.commit();
		}
	}

	private void serviceImport() throws Exception {
		Date updated_at = null;
		while (true) {
			// 如果没有更新查询SOLR中是否有数据
			if (updated_at == null) {
				SolrQuery query = new SolrQuery();
				query.setQuery("*:*");
				query.addSort("updated_at", SolrQuery.ORDER.desc);
				query.setRows(1);
				QueryResponse rsp = service_server.query(query);
				SolrDocumentList docs = rsp.getResults();
				log.info(docs.size());
				if (docs.size() > 0) {
					SolrDocument resultDoc = docs.get(0);
					updated_at = (Date) resultDoc
							.getFieldValue("updated_at");
					log.info("updated_at:" + updated_at);
					// updated_at=new Date(updated_at.getTime());
					log.info("solar back updated_at is: " + updated_at);
				}
			}

			List<BusinessService> serviceList = null;
			if (updated_at == null) {
				// solr中无数据直接从数据库取数据
				serviceList = businessServiceDao.businessListOrderByUpdatedAt(updated_at, 1000);
			} else {
				// 如果有SOLR中有数据从数据库取比SOLR中时间晚的
				serviceList =  businessServiceDao.businessListOrderByUpdatedAt(updated_at, 1000);
			}

			log.info("serviceList size: " + serviceList.size());

			if (serviceList.size() == 0) {
				break;
			}
			Collection<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
			List<String> deleteIdList = new ArrayList<String>();
			for (BusinessService service : serviceList) {
				if (service.getId() == 0.2) {
					deleteIdList.add(service.getId().toString());
					continue;
				} else {
					SolrInputDocument doc1 = serviceSolrDocument(service);
					docList.add(doc1);
				}
			}

			updated_at = serviceList.get(serviceList.size() - 1).getUpdated_at();
			System.out.println("new updated_at:" + updated_at);
			if (docList.size() > 0) {
				service_server.add(docList);
			}
			if (deleteIdList.size() > 0) {
				service_server.deleteById(deleteIdList);
			}
			service_server.commit();
		}
	}

	private void appealImport() throws Exception {
		Date updated_at = null;
		while (true) {
			// 如果没有更新查询SOLR中是否有数据
			if (updated_at == null) {
				SolrQuery query = new SolrQuery();
				query.setQuery("*:*");
				query.addSort("updated_at", SolrQuery.ORDER.desc);
				query.setRows(1);
				QueryResponse rsp = appeal_server.query(query);
				SolrDocumentList docs = rsp.getResults();
				log.info(docs.size());
				if (docs.size() > 0) {
					SolrDocument resultDoc = docs.get(0);
					updated_at = (Date) resultDoc
							.getFieldValue("updated_at");
					log.info("updated_at:" + updated_at);
					// updated_at=new Date(updated_at.getTime());
					log.info("solar back updated_at is: " + updated_at);
				}
			}

			List<Appeal> appealList = null;
			if (updated_at == null) {
				// solr中无数据直接从数据库取数据
				appealList = appealDao.appealListOrderByUpdatedAt(updated_at, 1000);
			} else {
				// 如果有SOLR中有数据从数据库取比SOLR中时间晚的
				appealList = appealDao.appealListOrderByUpdatedAt(updated_at, 1000);
			}

			log.info("appealList size: " + appealList.size());

			if (appealList.size() == 0) {
				break;
			}
			Collection<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
			List<String> deleteIdList = new ArrayList<String>();
			for (Appeal appeal : appealList) {
				if (appeal.getId() == 0.2) {
					deleteIdList.add(appeal.getId().toString());
					continue;
				} else {
					SolrInputDocument doc1 = appealSolrDocument(appeal);
					docList.add(doc1);
				}
			}

			updated_at = appealList.get(appealList.size() - 1).getUpdated_at();
			System.out.println("new updated_at:" + updated_at);
			if (docList.size() > 0) {
				appeal_server.add(docList);
			}
			if (deleteIdList.size() > 0) {
				appeal_server.deleteById(deleteIdList);
			}
			appeal_server.commit();
		}
	}

	/**
	 * 搜简历
	 * @param text
	 * @param offset
	 * @param rows
	 * @param city_id
	 * @param position_id
	 * @param industry_id
	 * @return
	 * @throws SolrServerException
	 */
	public List<Resume> resumeSearch(String text, int offset, int rows,String city_id,String position_id,String industry_id) throws SolrServerException{
		SolrQuery query = new SolrQuery();
		log.info("text is :" + text);
		if (StringUtil.isEmpty(text)) {
			query.setQuery("*:*");
		} else {
			query.setQuery(text);
		}
		if (!StringUtil.isEmpty(city_id)) {
			query.addFilterQuery("city_id:"+city_id);
		}

		if (!StringUtil.isEmpty(position_id)) {
			query.addFilterQuery("position_id:"+position_id);
		}

		if (!StringUtil.isEmpty(industry_id)) {
			query.addFilterQuery("industry_id:"+industry_id);
		}
		query.setHighlight(true);
		query.setParam("hl.fl", "title");
	    query.setHighlightSimplePre("<font color=\"red\">");
	    query.setHighlightSimplePost("</font>");



		query.addSort("updated_at", SolrQuery.ORDER.desc);
		query.setRows(rows);
		query.setStart(offset);
		QueryResponse rsp = null;
		List<Resume> resumeList = new ArrayList<Resume>();
		try{
			 rsp = resume_server.query(query);
		}catch (Exception e){
			e.printStackTrace();
			return resumeList;
		}

		SolrDocumentList docs = rsp.getResults();

		log.info("docs.size(): "+ docs.size());
		for (int i = 0; i < docs.size(); i++) {

			SolrDocument resumeDoc = docs.get(i);

			log.info(resumeDoc.getFieldValue("title"));
			Resume resume = resumeDao.get(Long.valueOf(resumeDoc.getFieldValue("id").toString()));
			User user = userDao.get(resume.getUser_id());
			resume.setUser(user);

			City city = cityDao.getCity(resume.getCity_id());
			resume.setCity(city);
			if (null != city) {
				City parentCity = cityDao.getCity(city.getParent_id());
				resume.setParentCity(parentCity);
			}
			resumeList.add(resume);
		}

		Map<String, Map<String, List<String>>> highMap = rsp.getHighlighting();
		Set<String> highKeys = highMap.keySet();
		for (String key :highKeys) {
			log.info("key is :"+key);
			Map<String,List<String>> highMap2 = highMap.get(key);
			Set<String> highKeys2 = highMap2.keySet();
				for (String key2 :highKeys2) {
					log.info("key2 is :"+key2);
					List<String> listString = highMap2.get(key2);
					for (String highString : listString) {
						log.info("highString is :"+highString);
					}

				}
			}


		return resumeList;
	}

	/**
	 * 搜工作
	 * @param text
	 * @param offset
	 * @param rows
	 * @param city_id
	 * @param position_id
	 * @param industry_id
	 * @return
	 * @throws SolrServerException
	 */
	public List<Job> jobSearch(String text, int offset, int rows,String city_id,String position_id,String industry_id) throws SolrServerException{
		SolrQuery query = new SolrQuery();
		if (StringUtil.isEmpty(text)) {
			query.setQuery("*:*");
		} else {
			query.setQuery(text);
		}

		if (!StringUtil.isEmpty(city_id)) {
			query.addFilterQuery("city_id:"+city_id);
		}

		if (!StringUtil.isEmpty(position_id)) {
			query.addFilterQuery("position_id:"+position_id);
		}

		if (!StringUtil.isEmpty(industry_id)) {
			query.addFilterQuery("industry_id:"+industry_id);
		}

		query.addSort("updated_at", SolrQuery.ORDER.desc);
		query.setRows(rows);
		query.setStart(offset);
		QueryResponse rsp = null;
		List<Job> jobList = new ArrayList<Job>();
		try{
			 rsp = job_server.query(query);
		}catch (Exception e){
			e.printStackTrace();
			return jobList;
		}

		SolrDocumentList docs = rsp.getResults();

		for (int i = 0; i < docs.size(); i++) {
			SolrDocument resumeDoc = docs.get(i);
			Job job = recruitmentDao.getJob(Long.valueOf(resumeDoc.getFieldValue("id").toString()));
			Company company = recruitmentDao.getUserCompany(job.getUser_id());
			job.setCompany(company);
			City city = cityDao.getCity(job.getCity_id());
			job.setCity(city);

			City parentCity = cityDao.getCity(city.getParent_id());
			job.setParentCity(parentCity);
			jobList.add(job);
		}
		return jobList;
	}

	/**
	 * 搜服务
	 * @param type_b
	 * @param types
	 * @param offset
	 * @param rows
	 * @param pcity_id
	 * @param city_id
	 * @return
	 * @throws SolrServerException
	 */
	public List<BusinessService> serviceSearch(String type_b,String types, int offset, int rows,String city_id) throws SolrServerException{
		SolrQuery query = new SolrQuery();
		if  (StringUtil.isEmpty(types)) {
			query.setQuery("*:*");
		} else {
			query.setQuery(types);
		}

		if (!StringUtil.isEmpty(city_id)) {
			query.addFilterQuery("city_id:"+city_id);
		}

		if (!StringUtil.isEmpty(type_b)) {
			query.addFilterQuery("type_b:"+type_b);
		}


		query.addSort("updated_at", SolrQuery.ORDER.desc);
		query.setRows(rows);
		query.setStart(offset);
		QueryResponse rsp = null;
		List<BusinessService> serviceList = new ArrayList<BusinessService>();
		try{
			 rsp = service_server.query(query);
		}catch (Exception e){
			e.printStackTrace();
			return serviceList;
		}

		SolrDocumentList docs = rsp.getResults();
		log.info("serviceSearch docs size is " + docs.size());
		for (int i = 0; i < docs.size(); i++) {
			SolrDocument resumeDoc = docs.get(i);

			BusinessService bs =businessServiceDao.getBusinessService(Long.valueOf(resumeDoc.getFieldValue("id").toString()));
			if (null != bs) {
				City city = cityDao.getCity(bs.getCity_id());
				bs.setCity(city);

				City parentCity = cityDao.getCity(city.getParent_id());
				bs.setParentCity(parentCity);
				serviceList.add(bs);
			}

		}
		return serviceList;
	}


	public List<Appeal> appealSearch(String type, int offset, int rows,String city_id) throws SolrServerException{
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		if  (!StringUtil.isEmpty(type)) {
			query.addFilterQuery("type:"+type);
		}
		if (!StringUtil.isEmpty(city_id)) {
			query.addFilterQuery("city_id:"+city_id);
		}


		query.addSort("updated_at", SolrQuery.ORDER.desc);
		query.setRows(rows);
		query.setStart(offset);
		QueryResponse rsp = null;
		List<Appeal> appealList = new ArrayList<Appeal>();
		try{
			 rsp = appeal_server.query(query);
		}catch (Exception e){
			e.printStackTrace();
			return appealList;
		}

		SolrDocumentList docs = rsp.getResults();

		for (int i = 0; i < docs.size(); i++) {
			SolrDocument resumeDoc = docs.get(i);
			Appeal appeal =appealDao.getAppeal(Long.valueOf(resumeDoc.getFieldValue("id").toString()));

			City city = cityDao.getCity(appeal.getCity_id());
			appeal.setCity(city);

			City parentCity = cityDao.getCity(city.getParent_id());
			appeal.setParentCity(parentCity);

			appealList.add(appeal);
		}
		return appealList;
	}

}
