function loadData() {

    $.getJSON("comments/load",
        function (data) {
            $('#results').text('');

            for (let index in data) {
                $('#results').append('<div style="margin-left: 5%;margin-right: 5%;margin-bottom: 3%;margin-top: 3%" class="border border-2 rounded mb-3">\n' +
                    '    <div style="margin-left: 5%;margin-right: 5%;margin-bottom: 3%;margin-top: 3%" class="row">\n' +  //comment start
                    data[index].user.username + '\n' +
                    '        <div class="item col-12 border border-1 rounded mb-2">\n' +
                    '            <p>' + data[index].comment +
                    '            </p>\n' +
                    '        </div>\n' +
                    '        <div id="rep' + index + '">\n' +
                    '            <button onclick="addField(this.id)" class="btn btn-info" id="' + index + '">Reply</button>\n' +
                    '        </div>\n' +
                    '    </div>\n' +        // comment end
                    '    <div id="div' + index + '"></div>\n' +
                    '    <div id="repliesDiv' + index + '" class="mb-3 row" style="margin-left: 15%;margin-right: 5%"></div>' +
                    '</div>');
                for (let reply in data[index]["replies"]) {
                    $('#repliesDiv' + index).append('' +
                        '    <div class="item col-12 border border-1 rounded mb-2">\n' +
                        '        <p>' + data[index]["replies"][reply].reply + '</p>\n' +
                        '    </div>');
                }
            } // comment and replies loader end
            loader();
        });

}

function addField(id) {
    $('#rep' + id).text('');
    $('#div' + id).append('<div class="mb-3" style="margin-left: 10%;margin-right: 5%">\n' +
        '            <textarea class="form-control" id="replyBox" placeholder="Type your reply..." rows="3"\n' +
        '                      style="resize: none;"></textarea>\n' +
        '            <div class="row mt-3">\n' +
        '                <div class="col-8"></div>\n' +
        '                <div class="col-2"><button class="btn btn-danger" id="cancel' + id + '" onclick="cancelRep(this.id)">Cancel</button></div>\n' +
        '                <div class="col-2"><button class="btn btn-success" id="replybtn' + id + '" onclick="sendReply(this.id)">Send</button></div>\n' +
        '            </div>' +
        '        </div>');
}

function cancelRep(id) {
    $('#rep' + id.substring(6)).append('<button onclick="addField(this.id)" class="btn btn-info" id="' + id.substring(6) + '">Reply</button>');
    $('#div' + id.substring(6)).text('');
}

function sendReply(id) {
    var reply = $("#replyBox").val();
    cancelRep('cancel' + id.substring(8));
    alert('Reply: ' + reply);
}

function addComment(username) {
    let comment = $('#commentBox').val();

    if ($('#commentBox').val().trim() == '') {   // validation
        $('#commentBox').val('');
        console.log('comment field not set');
    } else {

        $.getJSON("comments/add",
            {
                comment: comment,
                username: username
            },
            function (data) {
                $('#commentBox').val('');
                loadData();
            });
    }
}
