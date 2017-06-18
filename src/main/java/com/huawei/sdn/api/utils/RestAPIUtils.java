/**
 * 
 */
package com.huawei.sdn.api.utils;

import java.util.List;
import java.util.Map;

import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import lombok.extern.log4j.Log4j;

/**
 * @author huanglu
 *
 */
@Log4j
public class RestAPIUtils {
	private static SwaggerParser parser = new SwaggerParser();

	public static boolean compare(String path1, String path2) throws RestAPIParseException {

		Swagger swagger1 = parser.read(path1);
		Swagger swagger2 = parser.read(path2);

		// 比較basepath
		if (!swagger1.getBasePath().equals(swagger2.getBasePath())) {
			String msg = "the basepath is not equal, " + "the first  basepath is: ' " + swagger1.getBasePath()
					+ "the second basepath is: ' " + swagger2.getBasePath();
			throw new RestAPIParseException(msg);
		}

		// 处理path的比较
		Map<String, Path> paths1 = swagger1.getPaths();
		Map<String, Path> paths2 = swagger2.getPaths();

		for (Map.Entry<String, Path> entry : paths1.entrySet()) {

			log.info("path = " + entry.getKey());
			Path jsonPath1 = entry.getValue();

			// 查看paths2中是否有相同的路径,如果没找到，报异常
			if (!findPath(entry.getKey(), paths2)) {
				String msg = "path has missing " + "the path is: ' " + entry.getKey().toString();
				throw new RestAPIParseException(msg);
			}
			// 在paths2中查找是否有对应的key,如果没有则抛异常

			Path jsonPath2 = paths2.get(entry.getKey());

			/*// 比较Path中的方法
			List<Operation> operations1 = jsonPath1.getOperations();
			List<Operation> operations2 = jsonPath2.getOperations();

			boolean isOPEqual = false;
			String opResult = "";
			for (Operation op1 : operations1) {
				for (Operation op2 : operations2) {
					opResult = compareOperation(op1, op2);
					if (opResult.equals("equal"))
						isOPEqual = true;
				}
				if(isOPEqual==false){
					throw new RestAPIParseException(opResult);
				}
			}*/
			compareOperations(jsonPath1,jsonPath2);
		}

		return true;
	}

	
	private static void compareOperations(Path path1, Path path2) throws RestAPIParseException{
		
		if(null != path1.getGet()&&null!=path2.getGet()){
			compareOperation(path1.getGet(),path2.getGet());
		}
		
		if(null != path1.getPost()&&null!=path2.getPost()){
			compareOperation(path1.getPost(),path2.getPost());
		}
		
		if(null != path1.getPut()&&null!=path2.getPut()){
			compareOperation(path1.getPut(),path2.getPut());
		}
		
		if(null != path1.getPatch()&&null!=path2.getPatch()){
			compareOperation(path1.getPatch(),path2.getPatch());
		}
		
		if(null != path1.getDelete()&&null!=path2.getDelete()){
			compareOperation(path1.getDelete(),path2.getDelete());
		}
		
		if(null != path1.getHead()&&null!=path2.getHead()){
			compareOperation(path1.getHead(),path2.getHead());
		}
		
	}
	
	
	private static void compareOperation(Operation op1, Operation op2) throws RestAPIParseException {

		String msg = "equal";
		
		if (null == op1.getConsumes() || op1.getConsumes().isEmpty()) {

		} else {
			if (!op1.getConsumes().equals(op2.getConsumes())) {
				 msg = "Consumes is not equal, "+
						 "\nthe source is " + op1.getConsumes() +
						 "\nthe dest is " + op2.getConsumes();
				 throw new RestAPIParseException(msg);
			}
		}

		if (null == op1.getOperationId() || op1.getOperationId().isEmpty()) {
		} else {
			log.info("getOperationId");
			if (!op1.getOperationId().equals((op2.getOperationId()))) {
				 msg = "OperationId is not equal, "+
						 "\nthe source is " + op1.getOperationId() +
						 "\nthe dest is " + op2.getOperationId();
				 throw new RestAPIParseException(msg);
			}
		}

		if (null == op1.getParameters() || op1.getParameters().isEmpty()) {
		} else {
			log.info("getParameters");
			if (!op1.getParameters().equals(op2.getParameters())) {
				 msg = "Parameters is not equal, "+
						 "\nthe source is " + op1.getParameters() +
						 "\nthe dest is " + op2.getParameters();
				 throw new RestAPIParseException(msg);
			}
		}

		if (null == op1.getProduces() || op1.getProduces().isEmpty()) {
		} else {
			log.info("getProduces");
			if (!op1.getProduces().equals(op2.getProduces())) {
				msg = "Produces is not equal, "+
						 "\nthe source is " + op1.getProduces() +
						 "\nthe dest is " + op2.getProduces();
				 throw new RestAPIParseException(msg);
			}
		}

		if (null == op1.getResponses() || op1.getResponses().isEmpty()) {
		} else {
			log.info("getResponses");
			if (!op1.getResponses().equals(op2.getResponses())) {
				msg = "Responses is not equal, "+
						 "\nthe source is " + op1.getResponses() +
						 "\nthe dest is " + op2.getResponses();
				 throw new RestAPIParseException(msg);
			}
		}

		if (null == op1.getSchemes() || op1.getSchemes().isEmpty()) {
		} else {
			log.info("getSchemes");
			if (!op1.getSchemes().equals(op2.getSchemes())) {
				msg = "Schemes is not equal, "+
						 "\nthe source is " + op1.getSchemes() +
						 "\nthe dest is " + op2.getSchemes();
				 throw new RestAPIParseException(msg);
			}
		}

		if (null == op1.getSecurity() || op1.getSecurity().isEmpty()) {
		} else {
			log.info("getSecurity");
			if (!op1.getSecurity().equals(op2.getSecurity())) {
				msg = "Security is not equal, "+
						 "\nthe source is " + op1.getSecurity() +
						 "\nthe dest is " + op2.getSecurity();
				 throw new RestAPIParseException(msg);
			}
		}

	}

	private static boolean findPath(String path, Map<String, Path> map) {

		boolean result = false;
		for (Map.Entry<String, Path> entry : map.entrySet()) {
			if (path.equals(entry.getKey())) {
				System.out.println(entry.getKey());
				result = true;
			}
		}
		return result;
	}

}
