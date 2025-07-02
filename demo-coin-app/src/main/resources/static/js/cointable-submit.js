document.addEventListener("DOMContentLoaded", function () {
  const submitBtn = document.getElementById("submitCoins");
  const timestampLabel = document.getElementById("submitTimestamp");

  submitBtn.addEventListener("click", function () {
    fetch("/coinpage/coins", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(coinList),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Submission failed");
        }
        const now = new Date();
        const timeString = now.toLocaleTimeString([], {
          hour: '2-digit',
          minute: '2-digit',
          second: '2-digit',
        });
        timestampLabel.textContent = `Last submitted at ${timeString}`;
        return response.text();
      })
      .catch((error) => {
        console.error("Error submitting:", error);
      });
  });
});