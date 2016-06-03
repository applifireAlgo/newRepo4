package com.app.server.service.testbc.testingdomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.testbc.testingdomain.Stud;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "shweta.zagade@algorhythm.co.in", updatedBy = "shweta.zagade@algorhythm.co.in", versionNumber = "2", comments = "Service for Stud Master table Entity", complexity = Complexity.LOW)
public abstract class StudService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Stud entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Stud> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Stud entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Stud> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
