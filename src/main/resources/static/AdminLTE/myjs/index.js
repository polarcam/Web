const indexLocation=function (target){

    let targetHref = target.href;
    let targetId = target.id;
    $("#myiframe").attr("src",targetHref)

    if (targetId == "Option1"){
        $("#Option1").attr("class","nav-link active");
        $("#Option2").attr("class","nav-link");
        $("#Option3").attr("class","nav-link");
        $("#Option4").attr("class","nav-link");
        $("#Option5").attr("class","nav-link");
    } else if (targetId == "Option2") {
        $("#Option1").attr("class","nav-link");
        $("#Option2").attr("class","nav-link active");
        $("#Option3").attr("class","nav-link");
        $("#Option4").attr("class","nav-link");
        $("#Option5").attr("class","nav-link");
    } else if (targetId == "Option3") {
        $("#Option1").attr("class","nav-link");
        $("#Option2").attr("class","nav-link");
        $("#Option3").attr("class","nav-link active");
        $("#Option4").attr("class","nav-link");
        $("#Option5").attr("class","nav-link");
    } else if (targetId == "Option4"){
        $("#Option1").attr("class","nav-link");
        $("#Option2").attr("class","nav-link");
        $("#Option3").attr("class","nav-link");
        $("#Option4").attr("class","nav-link active");
        $("#Option5").attr("class","nav-link");
    } else {
        $("#Option1").attr("class","nav-link");
        $("#Option2").attr("class","nav-link");
        $("#Option3").attr("class","nav-link");
        $("#Option4").attr("class","nav-link");
        $("#Option5").attr("class","nav-link active");
    }

    return false;
}