
package application;

public class Cashier
{
	protected String name;
	protected String id;

	public Cashier()
	{
		name = new String();
		id = new String();
	}

	public Cashier(String inputName, String inputID)
	{
		name = inputName;
		id = inputID;
	}

	public Cashier copy()
	{
		return new Cashier(new String(name), new String(id));
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String inputName)
	{
		name = inputName;
	}
}