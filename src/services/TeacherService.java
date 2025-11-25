package services;

import models.Teacher;
import java.util.ArrayList;

public class TeacherService {

    private ArrayList<Teacher> teachers = new ArrayList<>();

    // إضافة معلم
    public void addTeacher(Teacher t) {
        teachers.add(t);
        System.out.println("Teacher added successfully.");
    }

    // البحث عن معلم باستخدام ID
    public Teacher searchById(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    // تعديل بيانات معلم
    public boolean updateTeacher(int id, String newName, String newSubject, String newPhone) {
        Teacher t = searchById(id);
        if (t != null) {
            if (newName != null) t.setName(newName);
            if (newSubject != null) t.setSubject(newSubject);
            if (newPhone != null) t.setPhone(newPhone);
            return true;
        }
        return false;
    }

    // حذف معلم
    public boolean deleteTeacher(int id) {
        Teacher t = searchById(id);
        if (t != null) {
            teachers.remove(t);
            return true;
        }
        return false;
    }

    // عرض كل السجلات
    public void showAll() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        for (Teacher t : teachers) {
            t.displayInfo();
        }
    }
}
