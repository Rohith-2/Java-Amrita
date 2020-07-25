package tree;

public interface Set {
public SetTree union(SetTree a);
public void insert(int e);
public void delete(int e);
public void preorder();
}
