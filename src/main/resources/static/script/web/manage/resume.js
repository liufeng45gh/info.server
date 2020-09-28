function modyinfo(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/info/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}

function closeModifyDiv(){
	$("#modify_inner_div").css("display","none");
}

function addExperence(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/experence/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}
 


function deleteJobExperience(id){
	if(!confirm("确认删除?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/job_experience/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyJobExperience(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/experence/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}

function refreshResume(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/refresh',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function closeResume(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/close',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function openResume(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/open',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function addProjectExperience(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/project_experience/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function deleteProjectExperience(id){
	if(!confirm("确认删除项目经验?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/project_experience/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyProjectExperience(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/project_experience/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}



function addEducationExperienceInput(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/education_experience/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function deleteEducationExperience(id){
	if(!confirm("确认删除教育经历?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/education_experience/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyEducationExperience(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/education_experience/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function addTrainInput(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/train/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function deleteTrain(id){
	if(!confirm("确认删除培训经历?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/train/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyTrain(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/train/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function addCertificateInput(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/certificate/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function deleteCertificate(id){
	if(!confirm("确认删除证书?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/certificate/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyCertificate(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/certificate/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function addLanguageInput(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/language/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function deleteLanguage(id){
	if(!confirm("确认删除语言能力?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/language/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyLanguage(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/language/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function addExpandInput(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.resume_id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/expand/add',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}


function deleteExpand(id){
	if(!confirm("确认删除自定义说明?")){
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/resume/expand/delete',
	   data: send_data,
	   dataType: 'json'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();
		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function modifyExpand(id){
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.id = id;
	var account_request =$.ajax({
	   type: 'get',
	   url: '/manage/resume/expand/update',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		$("#modify_inner_div").css("display","block");
		$("#modify_inner_div").html(data); 
	});
}

function ignoreResume(apply_id){
	if (!confirm("确认忽略？")) {
		return ;
	}
	var send_data={};
	   //alert(1);
	send_data.random = Math.random();
	send_data.apply_id = apply_id;
	var account_request =$.ajax({
	   type: 'post',
	   url: '/manage/job/ignore-resume',
	   data: send_data,
	   dataType: 'html'
	});

	account_request.fail(function( jqXHR, textStatus ) {
	  if(jqXHR.status==401){
	     //openWeiboLogin();		  
	  }
	});
	
	account_request.done(function(data) {
		window.location.reload();
	});
}

function sendInterviewInvitation(apply_id){
	layer.prompt({
	    formType: 2,
	    value: '',
	    title: '请给求职者捎句话吧,加上面试时间'
	}, function(value, index, elem){
	    //alert(value); //得到value
	    layer.close(index);
	    var send_data={};
		   //alert(1);
		send_data.random = Math.random();
		send_data.apply_id = apply_id;
		send_data.content = value;
		var account_request =$.ajax({
		   type: 'post',
		   url: '/manage/job/send-interview',
		   data: send_data,
		   dataType: 'json'
		});

		account_request.fail(function( jqXHR, textStatus ) {
		  if(jqXHR.status==401){
		     //openWeiboLogin();		  
		  }
		});
		
		account_request.done(function(data) {
			layer.msg('邀请已经发出!');
		});
	});
}