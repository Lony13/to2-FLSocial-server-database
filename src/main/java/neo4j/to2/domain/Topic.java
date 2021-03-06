package neo4j.to2.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Topic {
    @Id
    @GeneratedValue
    private Long topicID;

    @Property
    private String text;

    @Relationship(type = "HAS_SECTION", direction = Relationship.UNDIRECTED)
    private Section section;

    @Relationship(type = "HAVE", direction = Relationship.UNDIRECTED)
    private List<Answer> answers;

    @Relationship(type = "CREATED_BY", direction = Relationship.UNDIRECTED)
    private User creator;

    @Relationship(type = "PLUSED_BY", direction = Relationship.UNDIRECTED)
    private List<User> usersPlus;

    @Relationship(type = "MINUSSED_BY", direction = Relationship.UNDIRECTED)
    private List<User> usersMinus;

    public Topic() {
    }

    public Topic(Long topicID) {
        this.topicID = topicID;
    }

    public Topic(String text) {
        this.text = text;
    }

    public Topic(String text, User creator) {
        this.text = text;
        this.creator = creator;
    }

    public Long getTopicID() {
        return topicID;
    }

    public void setTopicID(Long topicID) {
        this.topicID = topicID;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addAnswer(Answer answer){
        if(answers == null){
            answers = new ArrayList<>();
        }
        answers.add(answer);
    }

    public List<User> getUsersPlus() {
        return usersPlus;
    }

    public void setUsersPlus(List<User> usersPlus) {
        this.usersPlus = usersPlus;
    }

    public void addUserPlus(User userPlus){
        if(usersPlus == null){
            usersPlus = new ArrayList<>();
        }
        usersPlus.add(userPlus);
    }

    public void removeUserPlus(User userPlus){
        if(usersPlus != null){
            usersPlus.remove(userPlus);
        }
    }

    public List<User> getUsersMinus() {
        return usersMinus;
    }

    public void setUsersMinus(List<User> usersMinus) {
        this.usersMinus = usersMinus;
    }

    public void addUserMinus(User userMinus){
        if(usersMinus == null){
            usersMinus = new ArrayList<>();
        }
        usersMinus.add(userMinus);
    }

    public void removeUserMinus(User userMinus){
        if(usersMinus != null){
            usersMinus.remove(userMinus);
        }
    }
}
