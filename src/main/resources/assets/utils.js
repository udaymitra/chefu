
var postJSON = function(endpoint, data, onSuccess, onFailure) {
  console.log("Issueing query: " + JSON.stringify(data));
  $.ajax({
    type: "POST",
    url: endpoint,
    data: JSON.stringify(data),
    success: onSuccess,
    error: onFailure,
    dataType: 'json',
    contentType:"application/json; charset=utf-8",
  });
};

