document.addEventListener("DOMContentLoaded", function () {
  var coinFilter = document.getElementById("coinFilter");
  var coinRows = document.querySelectorAll(".coinRow");

  // Add an input event listener to the filter input
  coinFilter.addEventListener("input", function () {
    var filter = coinFilter.value.toUpperCase();

    coinRows.forEach(function (row) {
      // Safely query the coin ID element
      var coinIdElement = row.querySelector("td span");
      var coinId = coinIdElement ? coinIdElement.textContent.toUpperCase() : "";

      // Show or hide the row based on the filter
      if (coinId.indexOf(filter) > -1) {
        row.style.display = ""; // Show the row
      } else {
        row.style.display = "none"; // Hide the row
      }
    });
  });
});
