package eus.ehu.mastodonAPI.domain;

public class Status {
    String id;
    String username;
    String created_at;
    String in_reply_to_account_id;
    boolean sensitive;
    String spoiler_text;
    String visibility;
    String language;
    String uri;
    String content;
    int replies_count;
    int reblogs_count;
    int favourites_count;
    String edited_at;
    boolean favourited;
    boolean reblogged;
    boolean muted;
    boolean bookmarked;
    String url;
    Status reblog;

    class Account{
        String id;
        String username;
        String acct;
        String display_name;
        boolean locked;
        boolean bot;
        boolean discoverable;
        public String getName(){
            return username;
        }
    }
    Account account;

    public boolean rebloged(){
        return reblog != null;
    }
    public Status getRebloged(){
        return reblog;
    }
    public String getName(){
        return  account.getName();
    }
    public String getContent(){
        return content;
    }
    public String getDate(){
        return created_at;
    }


}
