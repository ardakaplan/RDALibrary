package com.ardakaplan.rdalibrary.base.files;

import android.os.Environment;

import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDATextFileProperty extends RDAFileProperty {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    protected File createFile() throws RDAFolderProperty.FileNotCreatedInteractionException {

        File file;

        if (RDAStringHelpers.isEmpty(getRootFilePath())) {

            file = new File(Environment.getExternalStorageDirectory().toString(), getFileName());

        } else {

            file = new File(getRootFilePath(), getFileName());
        }

        return file;
    }

    public File saveContent(String content) throws IOException, FileNotCreatedInteractionException {

        File file = createFile();

        try {

            String oldContent = getContent();

            if (RDAStringHelpers.isFilled(oldContent)) {

                content = oldContent + content;
            }

        } catch (FileNotFoundException e) {

            RDALogger.warn("PREVIOUSLY SAVED FILE NOT FOUND");
        }

        try (FileOutputStream stream = new FileOutputStream(file)) {

            stream.write(content.getBytes());
        }

        return file;
    }

    public File saveContent() throws IOException, FileNotCreatedInteractionException {

        return saveContent(content);
    }

    public String getContent() throws FileNotCreatedInteractionException, IOException {

        StringBuilder contentText = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()));

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            contentText.append(line);

            contentText.append('\n');
        }


        bufferedReader.close();


        return contentText.toString();
    }

}
