
package application;

import java.io.Serializable;

public class Register implements Serializable
{
	private static final long serialVersionUID = 101010L;	//serializable wants this

	private String	id;
	private String	model;
	private String	vendor;

	public Register()
	{

	}

	public Register(String inputID, String inputModel, String inputVendor)
	{
		id = inputID;
		model = inputModel;
		vendor = inputVendor;
	}

	public Register copy()
	{
		return new Register(new String(id), new String(model), new String(vendor));
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getVendor()
	{
		return vendor;
	}

	public void setVendor(String vendor)
	{
		this.vendor = vendor;
	}
}