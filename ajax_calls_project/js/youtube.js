    $(function(){
        $('#form-container').on('submit', function(e){
            e.preventDefault();
        var request = gapi.client.youtube.playlists.insert({
            part: 'snippet',
            type: 'video',
            q: city,
            maxResults: 3,
            order: 'viewCount'
        });
    request.execute(function(response){
        console.log(response);
    });
});
    });


    function init(){
        gapi.client.setApiKey('AIzaSyC6WDvF45oVfxDfjW2GTlGI8_rvz62SiwU');
        gapi.client.load('youtube', 'v3', function(){
        });
    }