function doSomething() {

    $.getJSON("hello",
        {COMMENT: $('#commentBox').val()},
        function (data) {
            $('#results').text('');
            $('#commentBox').val('');

            for (let index in data) {
                $('#results').append('<div style="margin-left: 5%;margin-right: 5%;margin-bottom: 3%" class="row">\n' +
                    '    <div class="item col-12 border border-2 rounded mb-2">\n' +
                    '        <p>' + data[index].comment +
                    '        </p>\n' +
                    '    </div>\n' +
                    '    <div>\n' +
                    '        <button onclick="helloWorld()" class="btn btn-info">Reply</button>\n' +
                    '    </div>\n' +
                    '</div>')
                // $('#results').append(data[index].comment + '<br>');
                // for (let reply in data[index]["replies"]) {
                //     $('#results').append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + data[index].replies[reply].reply + '<br>');
                // }
                // $('#results').append('<br>');

            }
        });

}


/*
<div style="margin-left: 5%;margin-right: 5%;" class="row">
    <div class="item col-12">
        <p>The arrangement of type involves the selection of typefaces, point size, line length, leading
            (line spacing), adjusting the spaces between groups of letters (tracking) and adjusting the
            space between pairs of letters (kerning).
        </p>
    </div>
    <div>
        <button class="btn btn-info">Reply</button>
    </div>
</div>
*/

function helloWorld() {
    alert('hello');
}