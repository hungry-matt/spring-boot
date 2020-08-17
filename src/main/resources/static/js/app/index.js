var index = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function(){
           _this.save();
        });
    }
    , save : function () {
        var data = {
            title : $('#title').val()
            , author : $('#author').val()
            , content : $('#content').val()
        };

        if(!confirm("저장 하시겠습니까?")) return false;

        $.ajax({
            type : 'post'
            , url : '/api/v1/posts'
            , dataType : 'json'
            , contentType : 'application/json; charset=utf-8'
            , data : JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

index.init();