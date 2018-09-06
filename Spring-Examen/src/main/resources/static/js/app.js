function validate() {
	var name = document.getElementById("name").value;
	var firstname = document.getElementById("firstname").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else if(firstname == ''){
		alert('Please enter a valid firstname.');
	} else {
		return true;
	}
}