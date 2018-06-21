"use strict";

var formattedFahr = "&deg;F";
var formattedCels = "&deg;C";

$(document).ready(function() {
  console.log("hello! we are ready to convert.");

  var convertedF2C, convertedC2F;
  var $resultsContainer = $('.results');


  $('#convert_temp').on('click', function(event){
    event.preventDefault();
    var tempToConvert = $('#temperature').val();
    console.log("You clicked the 'Convert!' button!");
    console.log("tempToConvert: " + tempToConvert);

    /*
      this time, I convert the number entered (still checking that it's
      a number) and display the number as a temp in both scales and 
      converted in both scales.
    */
    if ($.isNumeric(tempToConvert)) {
      convertedF2C = fahrToCels(tempToConvert);
      convertedC2F = celsToFahr(tempToConvert);

      var resultFahr = "<p>" + tempToConvert + formattedFahr + " в Цельсиях " + convertedF2C +  formattedCels + "</p>";
      var resultCels = "<p>" + tempToConvert + formattedCels + " в Фаригитах " + convertedC2F + formattedFahr + "</p>";
      
      /*
        emptying results & clearing classes, in case someone's entering
        new numbers without reloading the page
      */
      $resultsContainer.empty();
      $resultsContainer.removeClass("alert");
      $resultsContainer.removeClass("error");
      $resultsContainer.append(resultFahr, resultCels);
    } else if (tempToConvert === '') {
      $resultsContainer.addClass("alert");
      $resultsContainer.html("You didn't enter anything!");
    } else {
      $resultsContainer.addClass("error");
      $resultsContainer.html("Ah, we can only convert numbers.");
    };

  })
});

var fahrToCels = function (fahr) {
  return ((fahr - 32) * (5/9)).toFixed(0);
};

var celsToFahr = function (celsius) {
  return (((celsius * 9) / 5) + 32).toFixed(0);
};

/*

  I changed the name of the variables holding the converted numbers
  because I was mixing them up and showing the wrong info in the
  results, but I didn't realize I was until I converted temps I
  already know (0 and 32). Ugh.

  convertedF2C makes much more sense and will be used in the proper
  spot than convertedFahr did. Yikes.

*/