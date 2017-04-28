package groupProject.MLG.objectlayer;

public class Link {
	private int linkID;
	private String link;
	private String game;
	private int voteCount;
	private int userID;
	private String playerName;

	
	public Link(int linkID, String link, String game, int voteCount, int userID) {
		super();
		this.linkID = linkID;
		this.link = link;
		this.game = game;
		this.voteCount = voteCount;
		this.userID = userID;
	}
	public Link() {
		super();

	}
	
	public int getLinkID() {
		return linkID;
	}
	public void setLinkID(int linkID) {
		this.linkID = linkID;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}