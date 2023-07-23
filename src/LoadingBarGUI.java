import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoadingBarGUI extends JFrame {
    // folder path of the files that we are going to delete
    public static final String FOLDER_PATH = "files";

    // constructor
    public LoadingBarGUI(){
        // set the title of the GUI
        super("Delete Files");

        // set the size of the GUI
        setSize(563, 392);

        // set the close operation to exit on close to end the process after closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the location of the GUI to be in the center
        setLocationRelativeTo(null);

        addGuiComponents();
    }

    private void addGuiComponents(){
        // create the delete button
        JButton deleteButton = new JButton("Delete Files");

        // change the font of the button
        deleteButton.setFont(new Font("Dialog", Font.BOLD, 48));

        // perform action when button is clicked
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // store folder reference
                File folder = new File(FOLDER_PATH);

                // check to see if the folder var actually holds reference to a folder
                if(folder.isDirectory()){
                    // store all the files in an array
                    File[] files = folder.listFiles();

                    // only delete files if there are files in the folder
                    if(files.length > 0){
                        deleteFiles(files);
                    }else{
                        showResultDialog("No Files to Delete");
                    }
                }
            }
        });

        // add to the GUI
        add(deleteButton, BorderLayout.CENTER);

    }

    private void showResultDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setSize(300, 150);
        resultDialog.setLocationRelativeTo(this);

        // message label
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(messageLabel, BorderLayout.CENTER);

        // confirm button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Dialog", Font.BOLD, 18));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close the dialog after hitting the confirm button
                resultDialog.dispose();
            }
        });

        resultDialog.add(confirmButton, BorderLayout.SOUTH);
        resultDialog.setVisible(true);
    }

    private void deleteFiles(File[] files){
        // create a dialog where the progress bar will be stored in
        JDialog loadingDialog = new JDialog(this, "Deleting Files", true);
        loadingDialog.setSize(300, 100);
        loadingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        loadingDialog.setLocationRelativeTo(this);

        // progress bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the color of the progress bar to green
        progressBar.setForeground(Color.decode("#2c8558"));

        // initialize the progress bar value to 0%
        progressBar.setValue(10);

        // delete files thread
        Thread deleteFilesThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // calculate the num of files in the 'files' directory
                int totalFiles = files.length;

                // keep count of the num of files that are deleted
                int filesDeleted = 0;

                // keep track of the progress
                int progress;

                for(File file: files){
                    // delete file
                    if(file.delete()){
                        filesDeleted++;

                        // calculate the progress
                        progress = (int)((((double) filesDeleted / totalFiles) * 100));

                        try{
                            Thread.sleep(60);
                        }catch(InterruptedException interruptedException){
                            interruptedException.printStackTrace();
                        }

                        // update progress bar
                        progressBar.setValue(progress);
                    }
                }

                // dispose the loading dialog when the progress is complete
                if(loadingDialog.isVisible()){
                    loadingDialog.dispose();
                }

                // show result dialog
                showResultDialog("Files Deleted");
            }
        });

        // start the delete files thread
        deleteFilesThread.start();

        // add the percentage symbol
        progressBar.setStringPainted(true);

        loadingDialog.add(progressBar, BorderLayout.CENTER);
        loadingDialog.setVisible(true);
    }
}













