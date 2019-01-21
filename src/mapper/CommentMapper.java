package mapper;

import java.util.List;

import entity.Comment;

public interface CommentMapper {

	public List<Comment> findAll();
		/*List<Comment> list = new ArrayList<>();
		String sql = "SELECT ecId,reply,content,createTime,replyTime,nickName "
				+ " FROM easybuycomment ";*/

	public List<Comment> findPage(int pageno, int i);
		/*List<Comment> list = new ArrayList<Comment>();
		String sql = "SELECT ecId,reply,content,createTime,replyTime,nickName "
				+ " FROM easybuycomment ORDER BY `createTime` DESC LIMIT ? ,? ";*/

	public int creatcomm(String guestName, String guestContent);
		/*Timestamp createtime = new Timestamp(new Date().getTime());
		String sql = "INSERT INTO easybuycomment (content,createTime,nickName) "
				+ " VALUES (?,?,?)";
		int temp = super.update(sql, guestContent,createtime,guestName);*/

	public Comment findById(int ecid);
		/*Comment comm = null;
		String sql = "SELECT reply,content,createTime,replyTime,nickName "
				+ " FROM easybuycomment WHERE ecId = ? ";*/

	public int change(int ecid, String replyContent);
		/*String sql = "UPDATE easybuycomment SET reply = ? ,replyTime = ? WHERE ecId = ? ";
		Timestamp time = new Timestamp(new Date().getTime());
		int temp = super.update(sql, replyContent ,time ,ecid);*/

	public int dele(int pid);
		/*String sql = "DELETE FROM easybuycomment WHERE ecId = ? ";
		int temp = super.update(sql, pid);*/

}
