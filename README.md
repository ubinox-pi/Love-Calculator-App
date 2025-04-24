<div style="max-height: 500px; overflow-y: auto; background-color: #1c1c1c; color: white; padding: 20px; border-radius: 10px; font-family: monospace; border: 2px solid #e63946;">
  <h2>❤️ Love Calculator App</h2>
  <p>A fun Android app built using Java and Firebase that calculates the "love percentage" between two names. It also displays beautiful love quotes and stores data on Firebase.</p>

<h3>🌟 Features</h3>
  <ul>
    <li>Enter two names and calculate a fun love percentage.</li>
    <li>Display of random romantic quotes.</li>
    <li>Firebase Realtime Database integration to save user input data.</li>
    <li>Easter eggs for specific names (like kabita, ashish, ramjee, etc.).</li>
    <li>Full-screen immersive layout.</li>
    <li>Launch to Instagram-like screen from the app.</li>
  </ul>

<h3>🧠 How It Works</h3>
  <ol>
    <li>User inputs two names.</li>
    <li>The names are validated and compared:
      <ul>
        <li>If both names are the same, a special dialog is shown.</li>
        <li>If the names are from a predefined "group" list, another special dialog appears.</li>
      </ul>
    </li>
    <li>For other names:
      <ul>
        <li>A unique ID is generated using the names + a random number.</li>
        <li>ASCII sum of combined names is calculated.</li>
        <li>Percentage is derived from the ASCII value logic.</li>
      </ul>
    </li>
    <li>Result is displayed with an engaging dialog.</li>
    <li>Data is saved in Firebase under <code>love/{uniqueId}</code>.</li>
  </ol>

<h3>🛠 Tech Stack</h3>
  <ul>
    <li>Java</li>
    <li>Android SDK</li>
    <li>Firebase Realtime Database</li>
    <li>XML for UI design</li>
  </ul>

<h3>📦 Project Structure</h3>
  <pre><code>
com.mylove.bytemechanic/
│
├── MainActivity.java         # Main logic for UI and love calculation
├── Instagram.java            # Instagram-like activity (can be customized)
├── Dialog.java               # Custom dialog for results
├── res/
│   ├── layout/
│   │   └── activity_main.xml # UI layout
│   └── drawable/             # Image assets
├── AndroidManifest.xml
  </code></pre>

<h3>🔐 Permissions</h3>
  <p>Make sure to add any required permissions in <code>AndroidManifest.xml</code> if needed (e.g., internet access for Firebase):</p>
  <pre><code>&lt;uses-permission android:name="android.permission.INTERNET"/&gt;</code></pre>

<h3>🚀 Getting Started</h3>
  <ol>
    <li>Clone this repository.</li>
    <li>Open in Android Studio.</li>
    <li>Set up your Firebase project and link your app.</li>
    <li>Run on your Android device or emulator.</li>
  </ol>

<h3>📋 License</h3>
  <p>This project is made for educational and fun purposes. You can customize and use it freely!</p>

  <hr>
  <p style="text-align:center;">Made with ❤️ by <strong>[Ramjee Prasad]</strong></p>
</div>
