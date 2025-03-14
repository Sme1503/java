package sec01.exam02;

import java.util.Objects;

public class Member {
	
	String id;
	String name;
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name);
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	
	// 깊은 복사할 때 사용
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
