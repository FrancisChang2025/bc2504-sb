function updatePriceChange(row, coin) {
  // Determine class and symbols
  var priceClass =
    coin.priceChangePercent24h > 0
      ? "up"
      : coin.priceChangePercent24h < 0
      ? "down"
      : "neutral";

  var priceChangeIcon =
    coin.priceChangePercent24h > 0
      ? "▲"
      : coin.priceChangePercent24h < 0
      ? "▼"
      : "-";

  var priceChangeValue = Math.abs(coin.priceChangePercent24h).toFixed(2) + "%";

  // Find and update the parent span
  var priceChangeElement = row.find(".price-change");
  priceChangeElement
    .removeClass("up down neutral")
    .addClass(priceClass)
    .html(`${priceChangeIcon} ${priceChangeValue}`); // Update content directly
}

function formatDate(lastUpdated) {
  var date = new Date(lastUpdated);
  var year = date.getFullYear();
  var month = ("0" + (date.getMonth() + 1)).slice(-2); // Month is 0-indexed, so add 1
  var day = ("0" + date.getDate()).slice(-2);
  var hours = ("0" + date.getHours()).slice(-2);
  var minutes = ("0" + date.getMinutes()).slice(-2);
  var seconds = ("0" + date.getSeconds()).slice(-2);
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds} HKT`;
}

$(document).ready(function () {
  setInterval(function () {
    $.ajax({
      url: "/coinlist", // Your endpoint to fetch the updated coin data
      type: "GET",
      success: function (data) {
        console.log(data);
        // Iterate over each coin to update the values
        data.forEach(function (coin, index) {
          // Find the corresponding row using index or another unique identifier
          var row = $(`tr[data-coin-id='${coin.id}']`);

          if (row.length) {
            // Update last updated timestamp
            row.find(".last-updated").text(formatDate(coin.last_updated)); // Assuming already formatted

            // Update current price
            row
              .find("td:nth-child(2)")
              .text("$" + coin.current_price.toFixed(2));

            // Update market cap
            row
              .find("td:nth-child(4)")
              .text("$" + coin.market_cap.toLocaleString());

            // Update price change
            var priceClass =
              coin.price_change_percentage_24h > 0
                ? "up"
                : coin.price_change_percentage_24h < 0
                ? "down"
                : "neutral";
            var priceChangeIcon =
              coin.price_change_percentage_24h > 0
                ? "▲"
                : coin.price_change_percentage_24h < 0
                ? "▼"
                : "-";
            var priceChangeValue =
              Math.abs(coin.price_change_percentage_24h).toFixed(2) + "%";

            console.log(
              "data=" +
                priceClass +
                " " +
                priceChangeIcon +
                " " +
                priceChangeValue
            );
            // Find and update the parent span
            var priceChangeElement = row.find(".price-change");
            //console.log("priceChangeElement=" + priceChangeElement)
            priceChangeElement
              .removeClass("up down neutral")
              .addClass(priceClass)
              .html(`${priceChangeIcon} ${priceChangeValue}`);
          }
        });
      },
      error: function (err) {
        console.error("Error fetching updated coin data:", err);
      },
    });
  }, 30000); // Update every 30 seconds
});