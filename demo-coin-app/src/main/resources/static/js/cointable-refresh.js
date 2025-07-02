function formatDate(lastUpdated) {
  var date = new Date(lastUpdated);
  var year = date.getFullYear();
  var month = ("0" + (date.getMonth() + 1)).slice(-2); // Month is 0-indexed, so add 1
  var day = ("0" + date.getDate()).slice(-2);
  var hours = ("0" + date.getHours()).slice(-2); // UTC
  var minutes = ("0" + date.getMinutes()).slice(-2);
  var seconds = ("0" + date.getSeconds()).slice(-2);
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds} HKT`;
}

function updatePriceChange(row, coin) {
  const change = coin.price_change_percentage_24h || 0;
  const priceClass = change > 0 ? "up" : change < 0 ? "down" : "neutral";
  const priceChangeIcon = change > 0 ? "▲" : change < 0 ? "▼" : "-";
  const priceChangeValue = Math.abs(change).toFixed(2) + "%";

  var priceChangeElement = row.find(".price-change");

  priceChangeElement
    .removeClass("up down neutral")
    .addClass(priceClass)
    .html(`${priceChangeIcon} ${priceChangeValue}`);
}

function refresh() {
  $.ajax({
    url: "/coinpage/coins", // Your endpoint to fetch the updated coin data
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
          row.find("td:nth-child(2)").text("$" + coin.current_price.toFixed(2));

          // Update market cap
          row
            .find("td:nth-child(4)")
            .text("$" + coin.market_cap.toLocaleString());

          // Update price change
          updatePriceChange(row, coin);
        }
      });
    },
    error: function (err) {
      console.error("Error fetching updated coin data:", err);
    },
  });
}

// jQuery
$(document).ready(function () {
  refresh();
  setInterval(refresh, 30000); // Update every 30 seconds
});