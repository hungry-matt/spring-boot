$(document).ready(function() {
    $('#click-save').on({
        click : function() {
            save();
        }
    })
});

function save() {
    var data = {
        type : 'post'
        , url : '/api/click/v1'
        , data : {}
    }

    ajax(data);
}
