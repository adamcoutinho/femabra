(function(){


    // alert(document.forms.length);
    // alert(document.forms[0].action);
    // postAsync(document.forms[0].action);
    $('#id_loader').hide();
    function postAsync(controllerPost) {
         var objectData = $('#loginForm ').serialize();

         alert(objectData);
        $('#id_loader').show();
        $.ajax({
            type: "POST",
            // contentType: "application/json",
            url: controllerPost,
             async: false  ,

               // sync:true ,
            // data: JSON.stringify(controllerPost),
            data: objectData,
            // dataType: 'json',
            // dataType:'text/html',
            cache: false,
                timeout: 6000,
            success: function (response) {
                // console.log(dataSuccess);
                // if(dataSuccess.isValid()){
                //     $.notify("teste app");
                // }

                // $.notify(response);

                $('#id_messenger').html(response);

                // $.notify(objectData);
                $('#id_loader').show();
            },
            error: function (dataError) {

                // alert(JSON.stringify(e));
                // console.log("ERROR",JSON.stringify(dataError));
                alert(dataError);
            }

        });
    }

    function postForm(controllerPostUrl){

        alert(controllerPostUrl);
        // $.post(controllerPostUrl,function (data,status) {
        //  alert(data,status);
        // });
    }

    $('#id_submit').click(function(e){
        e.preventDefault();
        // e.preventDefault();
        // alert(document.forms[0].action);
        // postForm(document.forms[0].action);
        postAsync(document.forms[0].action);
        // window.location.href="http://localhost:7850/femabra/panel";


    });

    })();