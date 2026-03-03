# FINAL YEAR PROJECT REPORT: MINDNEST
## A Holistic Mental Wellness & Habit Tracking Ecosystem

---

### 1. INTRODUCTION
#### 1.1 Project Overview
**MindNest** is a comprehensive Android-based wellness application designed to empower users to take control of their mental and physical health. It moves beyond simple habit tracking by integrating multiple health dimensions into a single, actionable metric: the **Mind Score**.

#### 1.2 Problem Statement
In the modern digital age, mental health is often neglected. Most health apps are fragmented—one tracks water, another tracks sleep, and another handles meditation. Users lack a unified view of how these different habits interact to affect their overall mental well-being.

#### 1.3 Solution
MindNest solves this by aggregating data from various modules (Journaling, Hydration, Fitness, Sleep, Tasks) and applying a weighted algorithm to provide a "Holistic Wellness Score."

---

### 2. SYSTEM REQUIREMENTS
#### 2.1 Software Requirements
*   **Operating System:** Android 8.0 (Oreo) and above.
*   **Development Language:** Kotlin 1.9.x.
*   **IDE:** Android Studio Iguana/Jellyfish.
*   **Database:** Room (Local), Firebase Firestore (Cloud).
*   **Version Control:** Git.

#### 2.2 Hardware Requirements (Minimum)
*   **Processor:** Quad-core 1.8 GHz.
*   **RAM:** 3GB.
*   **Storage:** 50MB free space.

---

### 3. TECHNICAL STACK & LIBRARIES
The project leverages modern Android development tools to ensure performance and responsiveness:
*   **Architecture:** MVVM (Model-View-ViewModel) with Clean Architecture principles.
*   **Jetpack Components:** LiveData, ViewModel, Room, ViewBinding, Navigation Component.
*   **Real-time Synchronization:** Firebase BOM (Auth, Firestore, Realtime Database).
*   **UI Scaling:**
    *   `com.intuit.sdp:sdp-android:1.1.1`: Scalable DP for multi-screen support.
    *   `com.intuit.ssp:ssp-android:1.1.1`: Scalable SP for consistent text sizing.
*   **Data Visualization:** `com.github.PhilJay:MPAndroidChart:v3.1.0` for 7-day trend analysis.
*   **Utilities:** `com.google.code.gson:gson:2.10.1` for complex data serialization.

---

### 4. CORE MODULES & IMPLEMENTATION
#### 4.1 Mind Score Algorithm (Mathematical Model)
The Mind Score is calculated daily based on a **Weighted Average Model**:
$$Score = (E \times 0.10) + (S \times 0.16) + (M \times 0.15) + (W \times 0.14) + (P \times 0.15) + (C \times 0.15) + (T \times 0.15)$$
Where:
*   **E (Emotional):** Mood logging.
*   **S (Sleep):** Duration vs. 8-hour target.
*   **M (Meditation):** Minutes of mindfulness.
*   **W (Water):** Intake vs. daily target.
*   **P (Physical):** Workout frequency.
*   **C (Calories):** Nutritional balance.
*   **T (Tasks):** Goal completion rate.

#### 4.2 PDF Report Generation Engine
A custom utility `PdfReportGenerator.kt` was developed to bridge the gap between digital tracking and physical documentation.
*   **API used:** `android.graphics.pdf.PdfDocument`.
*   **Features:** Color-themed branding, dynamic text wrapping, and bitmap injection for chart rendering.
*   **Security:** Uses Scoped Storage (MediaStore API) to save reports safely to the Downloads folder.

#### 4.3 Responsive UI Design
By using the **SDP** library, the app maintains a consistent layout on small 5-inch phones as well as 10-inch tablets, solving a major fragmentation issue in Android development.

---

### 5. DATABASE SCHEMA
The relational structure is managed via **Room Persistence Library**:
1.  **UserTable:** Stores profile, gender, and authentication tokens.
2.  **MindScoreTable:** Stores historical scores (Primary Key: Date + UserId).
3.  **TaskTable:** Daily to-do items with sync flags.
4.  **WaterTable:** Log entries for hydration tracking.
5.  **JournalTable:** Stores mood IDs and reflection text.
6.  **SleepTable:** Records sleep start and end timestamps.

---

### 6. METHODOLOGY
The project followed an **Agile Development Life Cycle**:
1.  **Requirement Analysis:** Identifying key wellness metrics.
2.  **Prototyping:** Designing the Lavender-themed UI.
3.  **Development:** Implementing modules incrementally (Tasks -> Water -> Mind Score).
4.  **Integration:** Connecting local Room DB with Firebase for cloud backup.
5.  **Reporting:** Building the PDF export functionality.

---

### 7. CONCLUSION
MindNest demonstrates how modern mobile technology can be used to improve personal health outcomes. By providing a single "Mind Score," it simplifies the complex task of self-monitoring and encourages users to maintain a balanced lifestyle.

---
**Submission Date:** [Insert Date]
**Academic Year:** 2023-2024
**Guide/Supervisor:** [Insert Name]
