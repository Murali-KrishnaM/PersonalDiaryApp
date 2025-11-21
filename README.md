# Personal Diary App

A lightweight and user-friendly **Personal Diary Android application** built using **Kotlin**.  
This app allows users to record daily thoughts, moods, and moments through clean and structured journal entries.  
Perfect for maintaining digital journals, tracking emotional wellness, and preserving daily memories.

---

## 🎯 Objective

Create a simple yet powerful personal diary experience that enables users to document their daily lives with ease.  
The app provides an intuitive interface for creating, viewing, and managing journal entries with mood tracking, timestamps, and organized storage — all without cloud sync or external dependencies.

---

## ✨ Features

### **Entry Management**
- **Create New Entries:** Quick access via Floating Action Button  
- **View All Entries:** Organized in reverse chronological order  
- **Detailed Entry View:** Full content display with mood indicators  
- **Timestamp Tracking:** Auto-generated and editable  

### **Mood Tracking**
- Emoji-based mood selector  
- Visual mood indicators in entry list and detail view  
- Supports moods like happy, sad, angry, neutral, etc.

### **User Interface**
- Smooth RecyclerView with dynamic list  
- Clean, distraction-free UI  
- Responsive layout optimized across devices  
- Simple, intuitive navigation  

---

## 🛠️ Technology Stack

| Component | Purpose |
|----------|---------|
| **Kotlin** | Core logic and activities |
| **Android Studio** | IDE and build tools |
| **RecyclerView** | Efficient list rendering |
| **XML Layouts** | UI templates and design |
| **Intents** | Screen navigation & data passing |
| **Data Classes** | Entry model structure |

---

## 📦 Installation

### **Prerequisites**
- Android Studio (latest recommended)  
- Android SDK (API Level 21+)  
- Kotlin support  
- Emulator or Android device  

### **Setup**
```bash
git clone https://github.com/yourusername/personal-diary-app.git
cd personal-diary-app
```

### **Open in Android Studio**
1. Launch Android Studio  
2. Select **Open an Existing Project**  
3. Choose the cloned directory  
4. Allow Gradle to sync  

### **Build & Run**
- Build → **Make Project**  
- Run → **Run 'app'**  

---

## 🚀 Usage

### **Creating Your First Entry**
1. Open the app  
2. Tap the **+** button  
3. Enter:
   - Title / Content  
   - Date & Time  
   - Mood  
4. Save the entry  

### **Viewing Entries**
- Scroll through the journal list  
- Tap an entry to open details  
- View full content, timestamp, and mood  

---

## 📱 User Interface Flow

```
[Journal List Screen]
        ↓ (Tap + button)
[Add Entry Screen]
        ↓ (Save entry)
[Back to Journal List]
        ↓ (Tap any entry)
[View Entry Details]
```

---

## 📊 App Structure

```
app/
├── java/com/example/diaryapp/
│   ├── JournalListActivity.kt
│   ├── AddEntryActivity.kt
│   ├── ViewEntryActivity.kt
│   ├── JournalListAdapter.kt
│   ├── JournalEntry.kt
│   └── EntryRepository.kt
└── res/layout/
    ├── activity_journal_list.xml
    ├── activity_add_entry.xml
    ├── activity_view_entry.xml
    └── item_entry.xml
```

---

## 🔧 Key Components

### **Activities**

| Activity | Description |
|----------|-------------|
| **JournalListActivity** | Main list of all entries |
| **AddEntryActivity** | Create new journal entry |
| **ViewEntryActivity** | View full entry details |

### **Data Model**
```kotlin
data class JournalEntry(
    val id: String,
    val title: String,
    val content: String,
    val timestamp: Long,
    val mood: String
)
```

### **Repository Pattern**
`EntryRepository` manages the in-memory storage:
- Add entries  
- Retrieve entries  
- List all entries  

### **Adapter**
`JournalListAdapter`:
- Binds entry data to list  
- Handles click events  
- Provides smooth scrolling  

---

## ⚡ Features Under the Hood
- Emoji-based mood indicators  
- Repository pattern for clean data management  
- Intent-based navigation  
- View Binding for efficient view access  
- Reverse chronological sorting  
- Modular architecture  

---

## 🎨 UI Layouts

### Layout Files

| Layout | Purpose |
|--------|---------|
| **activity_journal_list.xml** | List all entries |
| **activity_add_entry.xml** | Add new entry |
| **activity_view_entry.xml** | Full entry information |
| **item_entry.xml** | Row template for list items |

### Design Principles
- Minimal UI  
- Pleasant spacing & typography  
- Mood-driven visual elements  
- Easy-to-navigate screens  

---

## 🔄 How It Works

1. Launch → Loads all entries  
2. Add Entry → User inputs details  
3. Save → Entry stored in repository  
4. UI Refresh → Latest entry shown  
5. Tap Item → Open detailed view  

### Data Flow Diagram
```
User Input → AddEntryActivity → EntryRepository → JournalListActivity
                                       ↓
                                ViewEntryActivity
```

---

## 🚀 Future Enhancements
- Persistent storage (Room database)  
- Search functionality  
- Tags / categories  
- Image attachments  
- Export to PDF / text  
- PIN / biometric lock  
- Dark mode  
- Calendar view  
- Mood statistics  
- Cloud sync (optional)

---

## ⚠️ Important Notes

### **Data Persistence**
- Currently uses **in-memory only**  
- Data clears after app restarts  

### **Privacy**
- 100% offline  
- No analytics  
- No permissions required  

### **Compatibility**
- Minimum: Android 5.0 (API 21)  
- Target: Latest Android release  

---

## 🤝 Contributing

### Pull Request Steps
```bash
fork → create branch → commit → push → open PR
```

### Guidelines
- Follow Kotlin conventions  
- Keep architecture clean  
- Test across Android versions  
- Update documentation  

---

## 👨‍💻 Author

**Murali Krishna M**  
Android Development | Kotlin | UI/UX  
Email: **murali.krishna1591@gmail.com**

---

## ⭐ Support

If you found this project useful, please **star this repository**!

