package base;

import java.util.List;

public class BaseTable<T> {

	private List<T> data;
	private Long totalCount;
	
	public BaseTable(List<T> data,Long totalCount) {
		super();
		this.data = data;
		this.totalCount = totalCount;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
