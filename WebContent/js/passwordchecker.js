var pass1;
var pass2;
var checker1;
var checker2;

function checkStrength()
{
	pass1 = $("#pass1").val();
	checker1 = $("#checker1");

	if (pass1.length == null || pass1.length < 1)
	{
		checker1.html("Password field left empty");
	}
	else if (pass1.length < 4)
	{
		checker1.html("Weak Password");
	}
	else if (pass1.length > 4 && pass1.length < 8)
	{
		checker1.html("Good Password");
	}
	else
	{
		if (pass1.length > 8)
		{
			checker1.html("Strong Password");
		}
	}
}

function checkMatch()
{
	pass2 = $("#pass2").val();
	checker2 = $("#checker2");

	if (pass1 != pass2)
	{
		checker2.html("Passwords do not match!");
	}
	else
	{
		checker2.html("Hooray! Passwords match...");
	}
}