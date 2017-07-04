
    <% 
    Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
    ArrayList<Model.Departamento> departamentos = new ArrayList();
    
    resultados.pesquisarTodosDepartamentos();
    departamentos = resultados.getDepartamentos();
    %>

    <% 
    Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
    ArrayList<Model.Departamento> departamentos = new ArrayList();
    
    resultados.pesquisarTodosDepartamentos();
    departamentos = resultados.getDepartamentos();
    %>