
public class PojoClass {
	
	private String title;
	private String name;
	private String jobLocation;
	private String money;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description ;
	@Override
	public String toString() {
		return "PojoClass [title=" + title + ", name=" + name + ", jobLocation=" + jobLocation + ", money=" + money
				+ ", description=" + description + ", getTitle()=" + getTitle() + ", getName()=" + getName()
				+ ", getJobLocation()=" + getJobLocation() + ", getMoney()=" + getMoney() + ", getDescription()="
				+ getDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}	