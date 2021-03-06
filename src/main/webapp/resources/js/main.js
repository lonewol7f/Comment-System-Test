function loadData() {

    $.getJSON("comments/load",
        function (data) {
            data.reverse();
            $('#results').text('');

            for (let index in data) {
                $('#results').append('<div style="margin-left: 5%;margin-right: 5%;margin-bottom: 3%;margin-top: 3%" class="border border-2 rounded mb-3">\n' +
                    '    <div style="margin-left: 5%;margin-right: 5%;margin-bottom: 3%;margin-top: 3%" class="row">\n' +  //comment start
                    data[index].user.username + '\n' +
                    '        <div class="col-12 border border-1 rounded mb-2">\n' +
                    '            <div class="item">\n' +
                    '                <p>' + data[index].comment + '</p>\n' +
                    '            </div>\n' +
                    '            <div class="row">\n' +
                    '                <div class="col-6"></div>\n' +
                    '                <div class="col-3"><a href="javascript:void(0);" onclick="sayHello()">Update</a></div>\n' +
                    '                <div class="col-3"><a href="javascript:void(0);" onclick="sayHello()">Delete</a></div>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '        <div id="rep' + data[index].id + '">\n' +
                    '            <button onclick="addField(this.id)" class="btn btn-info" id="' + data[index].id + '">Reply</button>\n' +
                    '        </div>\n' +
                    '    </div>\n' +        // comment end
                    '    <div id="div' + data[index].id + '"></div>\n' +
                    '    <div id="repliesDiv' + data[index].id + '" class="mb-3 row" style="margin-left: 15%;margin-right: 5%"></div>' +
                    '</div>');
                for (let reply in data[index]["replies"]) {
                    $('#repliesDiv' + data[index].id).append('' +
                        '    <div class="col-12 border border-1 rounded mb-2">\n' +
                        '        <div class="item">\n' +
                        '            <p>' + data[index]["replies"][reply].reply + '</p>\n' +
                        '        </div>\n' +
                        '        <div class="row">\n' +
                        '            <div class="col-6"></div>\n' +
                        '            <div class="col-3"><a href="javascript:void(0);" onclick="sayHello()">Update</a></div>\n' +
                        '            <div class="col-3"><a href="javascript:void(0);" onclick="sayHello()">Delete</a></div>\n' +
                        '        </div>\n' +
                        '    </div>');
                }
            } // comment and replies loader end
            loader();
        });

}

function addField(id) {
    $('#rep' + id).text('');
    $('#div' + id).append('<div class="mb-3" style="margin-left: 10%;margin-right: 5%">\n' +
        '            <textarea class="form-control" id="replyBox' + id + '" placeholder="Type your reply..." rows="3"\n' +
        '                      style="resize: none;"></textarea>\n' +
        '            <div class="row mt-3">\n' +
        '                <div class="col-6"></div>\n' +
        '                <div class="col-3"><button style="float: right" class="btn btn-danger" id="cancel' + id + '" onclick="cancelRep(this.id)">Cancel</button></div>\n' +
        '                <div class="col-3"><button style="float: right" class="btn btn-success" id="replybtn' + id + '" onclick="sendReply(this.id)">Send</button></div>\n' +
        '            </div>' +
        '        </div>');
}

function cancelRep(id) {
    $('#rep' + id.substring(6)).append('<button onclick="addField(this.id)" class="btn btn-info" id="' + id.substring(6) + '">Reply</button>');
    $('#div' + id.substring(6)).text('');
}


function addComment() {
    let comment = $('#commentBox').val().trim();
    let username = $('#userName').val();

    if (comment == '') {   // validation
        $('#commentBox').val('');
        console.log('comment field not set');
    } else {

        $.getJSON("comments/add",
            {
                comment: comment,
                username: username
            },
            function () {
                $('#commentBox').val('');
                loadData();
            });

    }
}


function sendReply(id) {
    // var reply = $("#replyBox" + id.substring(8)).val().trim();
    var commentId = id.substring(8);
    var reply = $("#replyBox" + commentId).val().trim();
    var username = $('#userName').val();

    if (reply == '') {  // validation
        $("#replyBox" + commentId).val('');
        console.log('Reply field not set');
    } else {

        $.getJSON("replies/add",
            {
                commentId: commentId,
                username: username,
                reply: reply
            },
            function (data) {
                cancelRep('cancel' + commentId);
                loadData();
            });

    }

}


function sayHello() {
    console.log('hello');
}

function test() {

    $.ajax('test', {
        type: 'POST',  // http method
        data: {name: 'Kalana.'},  // data to submit
        success: function (data, status, xhr) {
            console.log(data, status);
        },
        error: function (jqXhr, textStatus, errorMessage) {
            console.log('Error');
        }
    });

    console.log('awoooooo')
}


