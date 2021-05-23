function ajax(data) {
    $.ajax({
        type : data.type
        , url : data.url
        , dataType : 'json'
        , contentType : 'application/json; charset=utf-8'
        , data : JSON.stringify(data)
    }).done(function(response){
        console.log(response);
        // alert(data.message);
        // window.location.href = '/';
    }).fail(function(error){
        alert(error.responseJSON.message);
    });
}