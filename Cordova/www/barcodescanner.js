(function() {
    window.addEventListener('message', function(e) {
    	if (e.data.slice(0, 'barcodescanner-'.length) == 'barcodescanner-') {
    		startBarCodeScanner();
    	}
    }, false);
    
    function startBarCodeScanner() {
    	
    	cordova.plugins.barcodeScanner.scan(
    			function (result) {
    				var iframe = document.getElementById('app');
    				if (iframe) {
    			    	iframe.contentWindow.postMessage("barcodescanned-" + result.text, "*");
    				}
    			}, 
    			function (error) {
    				alert("Scanning failed: " + error);
    			}
    	);
    	
	};

})();