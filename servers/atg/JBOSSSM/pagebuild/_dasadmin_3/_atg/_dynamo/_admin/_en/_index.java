package _dasadmin_3._atg._dynamo._admin._en;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import atg.nucleus.*;
import atg.naming.*;
import atg.service.filecache.*;
import atg.servlet.*;
import atg.droplet.*;
import atg.servlet.pagecompile.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import atg.servlet.jsp.*;

public class _index
extends atg.servlet.jsp.DynamoJspPageServlet implements atg.servlet.pagecompile.AttrCompiledServlet {
  public String getFileCacheAttributeName() {
    return "__002fatg_002fdynamo_002fadmin_002fen_002findex_xjhtml";
  }
  
  public static final long SOURCE_MODIFIED_TIME = 1401377604000L;
  static final atg.droplet.PropertyName _beanName0 = atg.droplet.PropertyName.createPropertyName("/atg/dynamo/admin/LoadControl.acceptingNewSessions");
  static final atg.droplet.PropertyName _beanName1 = atg.droplet.PropertyName.createPropertyName("/atg/dynamo/admin/LoadControl.acceptingNewSessions");
  public class _Param_0_unset extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_0_unset m_Param_0_unset = this. new _Param_0_unset();
  {
    m_Param_0_unset.setParent(this);
  }
  public class _Param_1_default extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
            /*** lines: 59-59 */
            __fileData.writeBytes (1355, 24, out);
            out.print(request.encodeURL ("/atg/dynamo/admin/en/configure-server.jhtml", true, true, false, true));
            request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
            /*** lines: 59-62 */
            __fileData.writeBytes (1422, 124, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_1_default m_Param_1_default = this. new _Param_1_default();
  {
    m_Param_1_default.setParent(this);
  }
  public class _Param_2_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 63-67 */
            __fileData.writeBytes (1583, 190, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_2_true m_Param_2_true = this. new _Param_2_true();
  {
    m_Param_2_true.setParent(this);
  }
  public class _SubServlet_3 extends PageSubServlet {
    {
      this.setParameter("unset", m_Param_0_unset);
      this.setParameter("default", m_Param_1_default);
      this.setParameter("true", m_Param_2_true);
    }
  }

  _SubServlet_3 m_SubServlet_3 = this. new _SubServlet_3();
  {
    m_SubServlet_3.setParent(this);
  }
  public class _Param_4_unset extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_4_unset m_Param_4_unset = this. new _Param_4_unset();
  {
    m_Param_4_unset.setParent(this);
  }
  public class _Param_5_default extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
            /*** lines: 79-79 */
            __fileData.writeBytes (2167, 23, out);
            out.print(request.encodeURL ("/atg/dynamo/admin/en/start-acc.jhtml", true, true, false, true));
            request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
            /*** lines: 79-82 */
            __fileData.writeBytes (2226, 123, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_5_default m_Param_5_default = this. new _Param_5_default();
  {
    m_Param_5_default.setParent(this);
  }
  public class _Param_6_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 83-87 */
            __fileData.writeBytes (2386, 166, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_6_true m_Param_6_true = this. new _Param_6_true();
  {
    m_Param_6_true.setParent(this);
  }
  public class _SubServlet_7 extends PageSubServlet {
    {
      this.setParameter("unset", m_Param_4_unset);
      this.setParameter("default", m_Param_5_default);
      this.setParameter("true", m_Param_6_true);
    }
  }

  _SubServlet_7 m_SubServlet_7 = this. new _SubServlet_7();
  {
    m_SubServlet_7.setParent(this);
  }
  public class _Param_8_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
            /*** lines: 105-105 */
            __fileData.writeBytes (3233, 78, out);
            out.print(request.encodeURL ("/nucleus/atg/dynamo/service/j2ee/J2EEContainer", true, true, false, true));
            request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
            request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
            /*** lines: 105-105 */
            __fileData.writeBytes (3357, 169, out);
            out.print(request.encodeURL ("/atg/dynamo/admin/en/performance.jhtml", true, true, false, true));
            request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
            /*** lines: 105-117 */
            __fileData.writeBytes (3564, 129, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_8_true m_Param_8_true = this. new _Param_8_true();
  {
    m_Param_8_true.setParent(this);
  }
  public class _Param_9_false extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
            /*** lines: 118-118 */
            __fileData.writeBytes (3728, 81, out);
            out.print(request.encodeURL ("/atg/dynamo/admin/en/performance-monitor.jhtml", true, true, false, true));
            request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
            /*** lines: 118-126 */
            __fileData.writeBytes (3855, 101, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_9_false m_Param_9_false = this. new _Param_9_false();
  {
    m_Param_9_false.setParent(this);
  }
  public class _SubServlet_10 extends PageSubServlet {
    {
      this.setParameter("true", m_Param_8_true);
      this.setParameter("false", m_Param_9_false);
    }
  }

  _SubServlet_10 m_SubServlet_10 = this. new _SubServlet_10();
  {
    m_SubServlet_10.setParent(this);
  }
  public class _Param_11_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
            /*** lines: 148-148 */
            __fileData.writeBytes (4797, 77, out);
            out.print(request.encodeURL ("/atg/dynamo/admin/en/show-dynamo-log.jhtml", true, true, false, true));
            request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
            /*** lines: 148-156 */
            __fileData.writeBytes (4916, 90, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_11_true m_Param_11_true = this. new _Param_11_true();
  {
    m_Param_11_true.setParent(this);
  }
  public class _SubServlet_12 extends PageSubServlet {
    {
      this.setParameter("true", m_Param_11_true);
    }
  }

  _SubServlet_12 m_SubServlet_12 = this. new _SubServlet_12();
  {
    m_SubServlet_12.setParent(this);
  }
  public class _Param_13_unset extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_13_unset m_Param_13_unset = this. new _Param_13_unset();
  {
    m_Param_13_unset.setParent(this);
  }
  public class _SubServlet_14 extends PageSubServlet {
  }

  _SubServlet_14 m_SubServlet_14 = this. new _SubServlet_14();
  {
    m_SubServlet_14.setParent(this);
  }
  public class _Param_15_default extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 167-168 */
            __fileData.writeBytes (5479, 11, out);

          request.setParameter("adminHomePageURL",
            request.getParameter("element.adminHomePagePrefixURL") + 
            request.getParameter("adminLang") + 
            request.getParameter("element.adminHomePageFragmentURL") );
                      /*** lines: 173-174 */
            __fileData.writeBytes (5756, 11, out);
            try {
              request.pushFrame();
              request.pushDefaultParameters(m_SubServlet_14.getParameters());
              ServletUtil.embed(request.getParameter("adminHomePageURL"), request, response);
            }
            finally {
              request.popFrame();
            }
            /*** lines: 174-175 */
            __fileData.writeBytes (5815, 9, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_15_default m_Param_15_default = this. new _Param_15_default();
  {
    m_Param_15_default.setParent(this);
  }
  public class _SubServlet_16 extends PageSubServlet {
    {
      this.setParameter("unset", m_Param_13_unset);
      this.setParameter("default", m_Param_15_default);
    }
  }

  _SubServlet_16 m_SubServlet_16 = this. new _SubServlet_16();
  {
    m_SubServlet_16.setParent(this);
  }
  public class _Param_17_output extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 163-164 */
            __fileData.writeBytes (5282, 7, out);
            try {
              request.pushFrame();
              request.setParameter("value", request.getObjectParameter("element.adminHomePageFragmentURL"));
              m_SubServlet_16.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 164);
            }
            finally {
              request.popFrame();
            }
            /*** lines: 176-177 */
            __fileData.writeBytes (5850, 5, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_17_output m_Param_17_output = this. new _Param_17_output();
  {
    m_Param_17_output.setParent(this);
  }
  public class _SubServlet_18 extends PageSubServlet {
    {
      this.setParameter("output", m_Param_17_output);
    }
  }

  _SubServlet_18 m_SubServlet_18 = this. new _SubServlet_18();
  {
    m_SubServlet_18.setParent(this);
  }
  public class _Param_19_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 228-228 */
            __fileData.writeBytes (7678, 28, out);
            /*** lines: 228-228 */
            __fileData.writeBytes (7767, 9, out);
            /*** lines: 228-228 */
            __fileData.writeBytes (7795, 36, out);
            {
              String _pn = "/atg/dynamo/admin/LoadControl.acceptingNewSessions";
              out.print(" name=\"");
              out.print(_pn);
              out.print('"');
              /*** lines: 228-228 */
              __fileData.writeBytes (7831, 1, out);
              if (_form != null) _form.addTag(request, response, null, _pn, "submit", null, DropletConstants.SUBMIT_PRIORITY_DEFAULT,"false",null, null, false);
            }
            /*** lines: 228-231 */
            __fileData.writeBytes (7832, 7, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_19_true m_Param_19_true = this. new _Param_19_true();
  {
    m_Param_19_true.setParent(this);
  }
  public class _Param_20_false extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 232-232 */
            __fileData.writeBytes (7876, 28, out);
            /*** lines: 232-232 */
            __fileData.writeBytes (7965, 1, out);
            /*** lines: 232-232 */
            __fileData.writeBytes (7984, 37, out);
            {
              String _pn = "/atg/dynamo/admin/LoadControl.acceptingNewSessions";
              out.print(" name=\"");
              out.print(_pn);
              out.print('"');
              /*** lines: 232-232 */
              __fileData.writeBytes (8021, 1, out);
              if (_form != null) _form.addTag(request, response, null, _pn, "submit", null, DropletConstants.SUBMIT_PRIORITY_DEFAULT,"true",null, null, false);
            }
            /*** lines: 232-234 */
            __fileData.writeBytes (8022, 7, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_20_false m_Param_20_false = this. new _Param_20_false();
  {
    m_Param_20_false.setParent(this);
  }
  public class _SubServlet_21 extends PageSubServlet {
    {
      this.setParameter("true", m_Param_19_true);
      this.setParameter("false", m_Param_20_false);
    }
  }

  _SubServlet_21 m_SubServlet_21 = this. new _SubServlet_21();
  {
    m_SubServlet_21.setParent(this);
  }
  public class _Param_22_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 225-226 */
            __fileData.writeBytes (7508, 5, out);
            try {
              request.pushFrame();
              request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/admin/LoadControl.acceptingNewSessions", true, null, null));
              m_SubServlet_21.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 226);
            }
            finally {
              request.popFrame();
            }
            /*** lines: 235-236 */
            __fileData.writeBytes (8053, 3, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_22_true m_Param_22_true = this. new _Param_22_true();
  {
    m_Param_22_true.setParent(this);
  }
  public class _SubServlet_23 extends PageSubServlet {
    {
      this.setParameter("true", m_Param_22_true);
    }
  }

  _SubServlet_23 m_SubServlet_23 = this. new _SubServlet_23();
  {
    m_SubServlet_23.setParent(this);
  }
  public class _Param_24_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 245-247 */
            __fileData.writeBytes (8419, 108, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_24_true m_Param_24_true = this. new _Param_24_true();
  {
    m_Param_24_true.setParent(this);
  }
  public class _SubServlet_25 extends PageSubServlet {
    {
      this.setParameter("true", m_Param_24_true);
    }
  }

  _SubServlet_25 m_SubServlet_25 = this. new _SubServlet_25();
  {
    m_SubServlet_25.setParent(this);
  }
  public class _Param_26_true extends PageSubServlet {
    
    //-------------- The service method
    public void service (DynamoHttpServletRequest request,
                         DynamoHttpServletResponse response)
        throws ServletException, IOException
    {
      ByteFileData __fileData = null;
      {
        __fileData = (ByteFileData)         request.getAttribute(getFileCacheAttributeName())        ;
        DynamoJspPageContext pageContext = (DynamoJspPageContext)request.getAttribute(DynamoJspPageContext.REQUEST_PAGE_CONTEXT_ATTR);
        
        ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
        
        int _jspTempReturn;
        
        try {
          String _saveBaseDir = null;
          try {
            if ((_saveBaseDir = request.getBaseDirectory()) != null)
              request.setBaseDirectory("/atg/dynamo/admin/en/");
            FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
            DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);
            /*** lines: 214-214 */
            __fileData.writeBytes (7148, 51, out);
            out.print(request.encodeURL ("/atg/dynamo/admin/images/bluedot.gif", false, true, true, true));
            _form = ((DropletEventServlet)request.getAttribute(DropletConstants.DROPLET_EVENT_ATTRIBUTE)).addForm("/atg/dynamo/admin/en/index.jhtml.18");
            if (_form != null) {
             String actionURI = ServletUtil.getRequestURI(request, "/atg/dynamo/admin/en/index.jhtml            ");
            _form.addActionURL(actionURI);
            }
            request.setParameter("_form", _form);
            /*** lines: 214-223 */
            __fileData.writeBytes (7235, 134, out);
            try {
              request.pushFrame();
              request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.drpEnabled", true, null, null));
              m_SubServlet_23.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 223);
            }
            finally {
              request.popFrame();
            }
            /*** lines: 237-243 */
            __fileData.writeBytes (8082, 199, out);
            try {
              request.pushFrame();
              request.setParameter("value", ServletUtil.toString(request.getNucleus().getShellRestart()));
              m_SubServlet_25.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 243);
            }
            finally {
              request.popFrame();
            }
            /*** lines: 248-251 */
            __fileData.writeBytes (8553, 22, out);
            if (_form != null && _form.needsEvents()){
            out.print("<input type=\"hidden\" name=\"_DARGS\" value=\"/atg/dynamo/admin/en/index.jhtml.18\"");
            if (_form != null && _form.isXMLMimeType(request))
            out.print("/>");
            else
            out.print(">");
            out.print("<input type=\"hidden\" name=\"_dynSessConf\" value=\"" + request.getSessionConfirmationNumber() + "\"");            if (_form != null && _form.isXMLMimeType(request))
            out.print("/>");
            else
            out.print(">");
            }
            _form = null;
            /*** lines: 251-253 */
            __fileData.writeBytes (8575, 16, out);
          }
          finally {
            if (_saveBaseDir != null) request.setBaseDirectory(_saveBaseDir);
          }
        } catch (Exception e) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
    }
  }
  _Param_26_true m_Param_26_true = this. new _Param_26_true();
  {
    m_Param_26_true.setParent(this);
  }
  public class _SubServlet_27 extends PageSubServlet {
    {
      this.setParameter("true", m_Param_26_true);
    }
  }

  _SubServlet_27 m_SubServlet_27 = this. new _SubServlet_27();
  {
    m_SubServlet_27.setParent(this);
  }
  
  public static final String[] INCLUDED_SOURCE_URIS = null;
  public static final long[] INCLUDED_SOURCE_MODIFIED_TIMES = null;
  public static String[] _jspDynGetSourceURIs() {
    return INCLUDED_SOURCE_URIS;
  }
  
  public final static String _JSP_ENCODING =   null  ;
  
  public static String _jspGetEncoding() {
    return _JSP_ENCODING;
  }
  

  //-------------------------------
  {
  
    DropletImports _imports = new DropletImports();
    this. setParameter("_imports", _imports);
    _imports.addImport("/atg/dynamo/Configuration");
    _imports.addImport("/atg/dynamo/droplet/Switch");
  }
  
  //-------------- The _jspService method
  public void _jspService (DynamoHttpServletRequest request,
                       DynamoHttpServletResponse response)
      throws ServletException, IOException
  {
    ByteFileData __fileData = null;
    try {
      __fileData = (ByteFileData)       request.getAttribute(getFileCacheAttributeName())      ;
      JspFactory _jspFactory = DynamoJspFactory.getDynamoJspFactory();
      DynamoJspPageContext pageContext = (DynamoJspPageContext)_jspFactory.getPageContext(
        this, request, response, 
        null,true, JspWriter.DEFAULT_BUFFER, true);
        ServletConfig config = getServletConfig();
        ServletContext application = config.getServletContext();
        HttpSession session = pageContext.getSession();
        Object page = this;
      
      ByteBufferedBodyContent out = (ByteBufferedBodyContent)pageContext.getOut();
      
      int _jspTempReturn;
      
      try {

        FormTag _form = (FormTag) request.getObjectParameter(ServletUtil.FORM_NAME);
        DropletImports _imports = (DropletImports) request.getObjectParameter(ServletUtil.IMPORTS_NAME);


String languages = request.getHeader("ACCEPT-LANGUAGE");
String result = "en";
if (languages != null) {
    for (;;) {
      String attempt = languages.substring(0,2);
      // check attempt
      String path = request.getRealPath("/atg/dynamo/admin/" + attempt);
      if ( (new java.io.File (path)).isDirectory() ) {
        // success
        result = attempt;
        break;
      }
      int index = languages.indexOf(",");
      if (index == -1)
        break;
      languages = languages.substring(index+1);
    }
}

request.setParameter( "adminLang", result );

        /*** lines: 24-26 */
        __fileData.writeBytes (585, 2, out);
        /*** lines: 29-29 */
        __fileData.writeBytes (688, 100, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/admin.css", false, true, true, true));
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 29-29 */
        __fileData.writeBytes (815, 136, out);
        out.print(request.encodeURL ("/", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        /*** lines: 29-47 */
        __fileData.writeBytes (952, 76, out);
        {
          Object _t = DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.version", true, PageCompileServlet.getEscapeHTMLTagConverter(), null);
          if (_t == null) {
            /*** lines: 48-47 */
            __fileData.writeBytes (1078, 1, out);
          }
            out.print(ServletUtil.toString(_t));
        }
        /*** lines: 47-56 */
        __fileData.writeBytes (1089, 92, out);
        try {
          request.pushFrame();
          request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.standaloneAssembledEarFile", true, null, null));
          m_SubServlet_3.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 56);
        }
        finally {
          request.popFrame();
        }
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 68-68 */
        __fileData.writeBytes (1798, 48, out);
        out.print(request.encodeURL ("/nucleus/", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        /*** lines: 68-76 */
        __fileData.writeBytes (1855, 138, out);
        try {
          request.pushFrame();
          request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.standaloneAssembledEarFile", true, null, null));
          m_SubServlet_7.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 76);
        }
        finally {
          request.popFrame();
        }
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 88-88 */
        __fileData.writeBytes (2577, 48, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/change-password.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 88-88 */
        __fileData.writeBytes (2667, 185, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/jdbcbrowser/", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        /*** lines: 88-103 */
        __fileData.writeBytes (2885, 200, out);
        try {
          request.pushFrame();
          request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.dynamoAppServer", true, null, null));
          m_SubServlet_10.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 103);
        }
        finally {
          request.popFrame();
        }
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 127-127 */
        __fileData.writeBytes (3978, 41, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/webservice/index.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 127-127 */
        __fileData.writeBytes (4062, 212, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/batchcompiler.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 127-127 */
        __fileData.writeBytes (4314, 167, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/conf-reporter.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        /*** lines: 127-146 */
        __fileData.writeBytes (4521, 128, out);
        try {
          request.pushFrame();
          request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.dynamoAppServer", true, null, null));
          m_SubServlet_12.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 146);
        }
        finally {
          request.popFrame();
        }
        /*** lines: 157-159 */
        __fileData.writeBytes (5028, 5, out);
        try {
          request.pushFrame();
          request.setParameter("array", DropletDescriptor.getPropertyValue(request, response, "/atg/modules/ModuleManager.modules", true, null, null));
          m_SubServlet_18.serviceByName(request, response, "/atg/dynamo/droplet/ForEach", 159);
        }
        finally {
          request.popFrame();
        }
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 178-178 */
        __fileData.writeBytes (5877, 75, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/sitemap/sitemap-admin.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 178-178 */
        __fileData.writeBytes (6000, 168, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/purges.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 178-178 */
        __fileData.writeBytes (6201, 143, out);
        out.print(request.encodeURL ("/dyn/admin/nucleus/atg/tracking/UsageTrackingReporter/", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 178-178 */
        __fileData.writeBytes (6398, 264, out);
        out.print(request.encodeURL ("/atg/dynamo/docs/", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        request.setParameterDelimiter(ServletUtil.getParamDelimiter(request));
        /*** lines: 178-178 */
        __fileData.writeBytes (6679, 150, out);
        out.print(request.encodeURL ("/atg/dynamo/admin/en/running-products.jhtml", true, true, false, true));
        request.setParameterDelimiter(DynamoHttpServletRequest.DEFAULT_PARAMETER_DELIMITER);
        /*** lines: 178-212 */
        __fileData.writeBytes (6872, 128, out);
        try {
          request.pushFrame();
          request.setParameter("value", DropletDescriptor.getPropertyValue(request, response, "/atg/dynamo/Configuration.dynamoAppServer", true, null, null));
          m_SubServlet_27.serviceByName(request, response, "/atg/dynamo/droplet/Switch", 212);
        }
        finally {
          request.popFrame();
        }
        /*** lines: 254-261 */
        __fileData.writeBytes (8613, 47, out);
/* @version $Id: //product/DAS/version/11.1/release/DAS/admin/atg/dynamo/admin/en/index.jhtml#1 $$Change: 875535 $*/        /*** lines: 261-261 */
        __fileData.writeBytes (8789, 1, out);
      } catch (Exception e) {
        if (!(e instanceof EndOfPageException)) {
          // out.clear();
          out.clearBuffer();
          pageContext.handlePageException(e);
        }
      }
      finally {
        pageContext.cleanupPoppedBodyContent();
        out.close();
        _jspFactory.releasePageContext(pageContext);
      }
    }
    finally {
      if (__fileData != null) __fileData.close();
    }
  }
}