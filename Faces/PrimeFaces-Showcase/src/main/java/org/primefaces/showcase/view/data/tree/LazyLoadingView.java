/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.showcase.view.data.tree;

import java.io.File;
import jakarta.faces.view.ViewScoped;
import org.primefaces.model.TreeNode;

import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;

@Named("treeLazyLoadingView")
@ViewScoped
public class LazyLoadingView implements Serializable {
    
    private TreeNode root;
    
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        FileInfo path = new FileInfo(context.getExternalContext().getRealPath("/"));
        root = new LazyLoadingTreeNode(path, (folder) -> listFiles(folder));
    }

    public static List<FileInfo> listFiles(String parentFolder) {
        File[] files = new File(parentFolder).listFiles();
        if (files == null) {
            return new ArrayList<>();
        }

        List<FileInfo> result = new ArrayList<>();
        for (File file : files) {
            result.add(new FileInfo(file.getAbsolutePath()));
        }
        return result;
    }

    public TreeNode getRoot() {
        return root;
    }
}
