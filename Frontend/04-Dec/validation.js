$(document).ready(function(){
    $("button").click(function(){
        var data1 = $("#x1").val();
        var data2 = $("#x2").val();
        var data3 = $("#x3").val();

        var regPincode = /^[1-9][0-9]{5}$/;
        var regMob = /^[0-9]{10}$/;
        var regPancard = /^([a-zA-Z]{5})([0-9]{4})([a-zA-Z])$/;

        var result = regPincode.test(data1);
        console.log(result);

        var result2 = regMob.test(data2);
        var result3 = regPancard.test(data3);

        if(!result ){
            $("p").html('<b>Invalid Pincode</b>');
        }
        else if(!result2){
            $("p").html('<b>Invalid Mobile Number</b> ');
        }
        else if(!result3){
            $("p").html('<b>Invalid Pancard</b>');
        }
        else{
            $("p").html('<b>Valid Data</b>');
        }
    });
})