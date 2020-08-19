var index = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function(){
           _this.save();
        });
        $('#btn-update').on('click', function(){
            _this.update();
        });
    }
    , save : function () {
        var data = {
            title : $('#title').val()
            , author : $('#author').val()
            , content : $('#content').val()
            , message : "글이 등록 되었습니다."
            , url : '/api/v1/posts'
            , type : 'post'
        };

        if(!confirm("저장 하시겠습니까?")) return false;

        this.postAjax(data);
    }
    , update : function() {
        var id = $('#id').val();

        var data = {
            title: $('#title').val()
            , content : $('#content').val()
            , message : "글이 수정 되었습니다."
            , url : '/api/v1/posts/' + id
            , type : 'put'
        };

        this.postAjax(data);
    }
    , postAjax : function(data) {
        $.ajax({
            type : data.type
            , url : data.url
            , dataType : 'json'
            , contentType : 'application/json; charset=utf-8'
            , data : JSON.stringify(data)
        }).done(function(){
            alert(data.message);
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};



index.init();