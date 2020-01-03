package controllers;

public class AddContactBean
{
	private String contactName;
	private String contactEmail;
	private String contactPhone;
	private String contactOf;
	private String isFavourite;

	public String getIsFavourite()
	{
		return isFavourite;
	}

	public void setIsFavourite(String isFavourite)
	{
		this.isFavourite = isFavourite;
	}

	public String getContactName()
	{
		return contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	public String getContactEmail()
	{
		return contactEmail;
	}

	public void setContactEmail(String contactEmail)
	{
		this.contactEmail = contactEmail;
	}

	public String getContactPhone()
	{
		return contactPhone;
	}

	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
	}

	public String getContactOf()
	{
		return contactOf;
	}

	public void setContactOf(String contactOf)
	{
		this.contactOf = contactOf;
	}
	
	

}
