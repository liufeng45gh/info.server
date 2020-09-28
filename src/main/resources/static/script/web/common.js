function validMailFormat(mail){
    //var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var filter = /^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;
    if (!filter.test(mail)){
       return false;
    }
    return true;
}

function validMobileFormat(mobile){
    var numberRegStr = /^\d{11}$/;
    var regNum = new RegExp(numberRegStr);
    if (regNum.test(mobile)) {
        var telRegStr = /^(13|14|15|17|18)\d{9}$/;
        var reg = new RegExp(telRegStr);
        if (reg.test(mobile)) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}