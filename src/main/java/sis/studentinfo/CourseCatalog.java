package sis.studentinfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseCatalog {

    private List<Session> sessions = new ArrayList<>();

    public void add(Session session) {
        sessions.add(session);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void clearAll() {
        sessions.clear();
    }

    public void store(String filename) throws IOException {
        ObjectOutputStream output = null;

        try {
//            output = new DataOutputStream(new FileOutputStream(filename));
//            output.writeInt(sessions.size());
//
//            for (Session session : sessions){
//                output.writeLong(session.getStartDate().getTime());
//                output.writeInt(session.getNumberOfCredits());
//                output.writeUTF(session.getDepartment());
//                output.writeUTF(session.getNumber());
            output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(sessions);
        }finally {
            output.close();
        }
    }

    public void load(String filename) throws IOException, ClassNotFoundException {
//        DataInputStream input = null;

        ObjectInputStream input = null;

        try {

            input = new ObjectInputStream(new FileInputStream(filename));
            sessions = (List<Session>) input.readObject();

//            input = new DataInputStream(new FileInputStream(filename));
//            int numberOfSessions = input.readInt();
//            for (int i = 0; i < numberOfSessions; i++){
//                Date startDate = new Date(input.readLong());
//                int credits = input.readInt();
//                String department = input.readUTF();
//                String number = input.readUTF();
//                Course course = new Course(department, number);
//
//                System.out.println("department : " + department +", number : " +  number + credits);
//
//                Session session = CourseSession.create(course, startDate);
//                session.setNumberOfCredits(credits);
//                sessions.add(session);


        }finally {
            input.close();
        }
    }
}
