<h1>Loading Bar GUI</h1>

<h2>Overview</h2>
<p>The Loading Bar GUI is a simple Java application that provides a graphical user interface (GUI) for deleting files from a specific folder. It uses Swing components to create the GUI, including a button to initiate the file deletion process and a progress bar to show the deletion progress. The application also displays a result dialog to inform the user about the outcome of the file deletion operation.</p>

<h2>Files</h2>

<ol>
  <li><strong>App.java</strong>: This file contains the main class <code>App</code>, which serves as the entry point for the application. It uses <code>SwingUtilities.invokeLater</code> to ensure that the GUI is created and shown on the Event Dispatch Thread.</li>

  <li><strong>LoadingBarGUI.java</strong>: This file contains the <code>LoadingBarGUI</code> class, which extends <code>JFrame</code> and represents the main GUI window of the application. It sets up the GUI components, including a "Delete Files" button. When the button is clicked, it initiates the file deletion process. The GUI also includes methods for showing result dialogs and a loading dialog with a progress bar to indicate the deletion progress.</li>
</ol>

<h2>Usage</h2>

<p>To use the Delete Files GUI, follow these steps:</p>

<ol>
  <li>Create a folder named "files" in the same directory as the compiled Java files.</li>

  <li>Compile the Java files:</li>
  <pre><code>javac App.java LoadingBarGUI.java</code></pre>

  <li>Run the compiled Java program:</li>
  <pre><code>java App</code></pre>

  <li>The Delete Files GUI window will appear.</li>

  <li>Click the "Delete Files" button to initiate the file deletion process. If there are files in the "files" folder, they will be deleted, and the progress bar will show the deletion progress. A result dialog will be displayed once the deletion process is complete.</li>
</ol>

<h2>Class Details</h2>

<h3>1. App.java</h3>

<p>This class contains the <code>App</code> class, which serves as the entry point for the application.</p>

<h4>Methods</h4>
<ul>
  <li><code>main(String[] args)</code>: The main method uses <code>SwingUtilities.invokeLater</code> to create an instance of <code>LoadingBarGUI</code> and make the GUI visible.</li>
</ul>

<h3>2. LoadingBarGUI.java</h3>

<p>This class represents the main GUI window of the application.</p>

<h4>Constructor</h4>
<ul>
  <li><code>LoadingBarGUI()</code>: Constructs a new <code>LoadingBarGUI</code> object. It sets up the JFrame with the title, size, close operation, and location. It then calls the <code>addGuiComponents()</code> method to add the GUI components.</li>
</ul>

<h4>Methods</h4>
<ul>
  <li><code>addGuiComponents()</code>: This method sets up the GUI components, including a "Delete Files" button with an action listener to initiate the file deletion process when clicked. It also adds the button to the GUI.</li>

  <li><code>showResultDialog(String message)</code>: This method displays a result dialog with the specified message.</li>

  <li><code>deleteFiles(File[] files)</code>: This method initiates the file deletion process in a separate thread. It creates a loading dialog with a progress bar to show the deletion progress. The method iterates through the files in the "files" folder and deletes them one by one. The progress bar updates to reflect the deletion progress. Once the deletion process is complete, it displays a result dialog with the message "Files Deleted."</li>
</ul>
