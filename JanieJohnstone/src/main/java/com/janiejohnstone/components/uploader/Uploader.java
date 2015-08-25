package com.janiejohnstone.components.uploader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.wicket.Resource;
import org.apache.wicket.markup.html.PackageResource;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.file.Folder;
import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.resource.IResourceStream;

public class Uploader extends Panel{
	private Folder uploadFolder;
	private List files = new ArrayList();
	private ListView fileList;
	public Uploader(String id, final String saveToFolder) {
		//getApplication().getApplicationSettings().
		super(id);
		WebApplication wa = (WebApplication) getApplication();
		
		//Logger.getAnonymousLogger().info(getApplication().getApplicationSettings().getContextPath());
		final FeedbackPanel uploadFeedback = new FeedbackPanel("uploadFeedback");
		//System.out.println("Hellllllllllloooooo");
		//System.out.println();
		
		add(uploadFeedback);
		uploadFolder = new Folder(wa.getServletContext().getRealPath("/WEB-INF/UploaderFiles/"+saveToFolder));
		uploadFolder.mkdir();
		
		System.out.println(wa.getServletContext().getRealPath("/WEB-INF/UploaderFiles/"+saveToFolder));
		
		for(final File f:uploadFolder.getFiles()){
			if(f.getName().contains("svn"))
				getApplication().getSharedResources().add(f.getName(), new PackageResource(Uploader.class, f.getName(), null, "en_GB"){
				@Override
					public IResourceStream getResourceStream() {
						return new FileResourceStream(f);
					}
				});

		}
		
		List<File> l = (List<File>) Arrays.asList(uploadFolder.getFiles());
		for(int i=0;i<l.size();i++){
			if(l.get(i).getName().contains("svn"))
				l.remove(i);
		}
		files.addAll(l);
		try {
			uploadFolder.ensureExists();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(new FileUploadForm("uploadForm"));
		add(fileList = new ListView("uploadedFiles",files ){
			@Override
			protected void populateItem(ListItem item) {
				// TODO Auto-generated method stub
				String fname = ((java.io.File)item.getModelObject()).getName();
				item.add(new Label("file", fname));
				item.add(new Image("image", "/UploaderFiles/"+saveToFolder+"/"+fname));
				//item.add(l);
			}
		});
	}
	private void refreshFiles()
	{
		fileList.modelChanging();
		files.clear();
		files.addAll(Arrays.asList(uploadFolder.listFiles()));
	}

	private class FileUploadForm extends Form {
		private FileUploadField field;
		public FileUploadForm(String id) {
			super(id);
			setMultiPart(true);
			field = new FileUploadField("fileInput");
			add(field);
			setMaxSize(Bytes.kilobytes(1000));
		}
		@Override
		protected void onSubmit() {
			// TODO Auto-generated method stub
			final FileUpload upload = field.getFileUpload();
			if(upload!=null){
				final File file = new File(uploadFolder,upload.getClientFileName());
				try {
					file.createNewFile();
					upload.writeTo(file);
					Uploader.this.info("saved file: " + upload.getClientFileName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				refreshFiles();
				//Logger.getAnonymousLogger().info("Saving shared resource:"+file.getName().toString());
				//PackageResource.bind(getApplication(), Uploader.class, file.getName());
				getApplication().getSharedResources().add(file.getName(), new PackageResource(Uploader.class, file.getName(), null, "en_GB"){
				@Override
					public IResourceStream getResourceStream() {
						return new FileResourceStream(file);
					}
				});
				
			}
		}
	}
}
