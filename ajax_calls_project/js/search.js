function handleAPILoaded() {
  $('#search-button').attr('disabled', false);
}

// Search for a specified string.
function search() {
  var request = gapi.client.youtube.search.list({
    q: city,
    part: 'snippet'
  });

  request.execute(function(response) {
    console.log(response) ;
    var str = JSON.stringify(response.result);
    $('#search-container').html('<pre>' + str + '</pre>');
  });
}