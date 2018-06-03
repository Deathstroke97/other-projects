
function loadData() {

    var $body = $('body');
    var $wikiElem = $('#wikipedia-links');
    var $nytHeaderElem = $('#nytimes-header');
    var $nytElem = $('#nytimes-articles');
    var $greeting = $('#greeting');
    $wikiElem.text("");
    $nytElem.text("");

    var street = $("#street").val();
    var city = $("#city").val();
   //document.getElementById("nytimes-header").innerHTML = "New York Times Articles about " + city;
    var source = street + ', ' + city; 
    $greeting.text("");
    $greeting.append("<h3 class ='font-effect-outline'>So you want to live at " +  source + " ?</h3>");
    var streetviewUrl = 'http://maps.googleapis.com/maps/api/streetview?size=600x300&location=' + source;

    $('body').append('<img class="bgimg" src="' + streetviewUrl+ '">');

    var intro = $('#nytimes-header').text();
    intro = intro  + " about " + city;
    
    var url = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
    url += '?' + $.param({
        'api-key': "edf0a00a4f4a4b9ca514a2b3c6873b78",
        'q': city
    });
    
    $.getJSON( url, function( data ) {
        $nytHeaderElem.text("");
        $nytHeaderElem.append("<h3 class = 'font-effect-outline'>New York Times Articles about " +  city + "</h3>");
        //$nytHeaderElem.text("New York Times Articles about " + city)
        var items = [];
        var myobj = data.response.docs;
        console.log(myobj);
        
        
    $.each( myobj, function( key, val ) {
        //console.log(val['multimedia'][6]['url'] == null);
        var result;
        if(val['snippet'] == null){
            val['snippet'] = val.lead_paragraph;
        }
        if(val['multimedia'].length == 0){
            result = 'https://static01.nyt.com/images/2017/01/28/nyregion/28xp-settlement_web1/28xp-settlement_web1-thumbWide.jpg';
        }
        else {
            result = "https://static01.nyt.com/" + val['multimedia'][1]['url'];
        }
           items.push( "<li class='article'><a href = '" + val['web_url'] + "'>" + 
        val['headline']['main'] +"</a><img src='"+result+"' width='210px' height='140px' class='img-thumbnail photo'><p>" + 
        val['snippet'] + "</p</li>");
       
    });
    $('#nytimes-articles').html(items.join(""));
    
    }).error(function(e){
        $nytHeaderElem.text('New York Times Articles Could Not be Loaded');
    });


    var url = 'https://en.wikipedia.org/w/api.php?action=opensearch&search=' + city + 
            '&format=json&callback=wikiCallback'; 

    var wikiRequestTimeout = setTimeout(function(){
        $wikiElem.append('<li class="error">failed to get wikipedia resources</li>');
    }, 8000);

    $.ajax({
        url: url,
        dataType: 'jsonp',
        success: function(response){
            var articleList = response[1];
            for (var i = 0; i < articleList.length; i++){
                articleStr = articleList[i];
                    var url = 'https://en.wikipedia.org/wiki/' + articleStr;
                        $wikiElem.append('<li><a href="'+ url +'">' + articleStr + '</a></li>');
            }
            clearTimeout(wikiRequestTimeout);
        }
    });
    return false;
}

$('#form-container').submit(loadData);





