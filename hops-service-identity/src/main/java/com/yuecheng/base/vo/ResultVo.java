/**
 * 
 */
package com.yuecheng.base.vo;

import java.io.Serializable;
import java.util.Objects;
import com.google.common.base.Strings;

public class ResultVo<T> implements Serializable {

	private static final long serialVersionUID = 4147361593051157967L;

	private String mesg;

	private Integer code;
	
	private String time;

	private T data;
	
	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResultVo<T> success(T value) {
		this.data = value;
		this.code = CodeEnum.SUCCEE.getCode();
		this.mesg = CodeEnum.SUCCEE.getDesc();
		return this;
	}
	
	public ResultVo<T> serviceException() {
		this.code = CodeEnum.BizExcep.getCode();
		this.mesg = "内部服务器异常";
		return this;
	}
	
	public ResultVo<T> serviceException(Throwable e) {
		this.code = CodeEnum.BizExcep.getCode();
		this.mesg = null != e ? e.getMessage() : "内部服务器异常";
		return this;
	}

	public ResultVo<T> bizException(String mesg) {
		this.code = CodeEnum.BizExcep.getCode();
		this.mesg = Strings.isNullOrEmpty(mesg) ? CodeEnum.BizExcep.getDesc() : mesg;
		return this;
	}

	public ResultVo<T> value(CodeEnum codeEnum, String mesg) {
		Objects.requireNonNull(codeEnum, "结果状态标识不能能为空");
		this.code = codeEnum.getCode();
		this.mesg = Strings.isNullOrEmpty(mesg) ? codeEnum.getDesc() : mesg;
		return this;
	}

	public enum CodeEnum {

		/** 200:正常返回,-1服务异常,1业务异常 , 401 未登录, 999没有权限, 503 Token失效 */
		SUCCEE(200) {
			@Override
			public String getDesc() {
				return "处理成功";
			}
		},
		ERROR(-1) {
			@Override
			public String getDesc() {
				return "内部服务异常";
			}
		},
		BizExcep(1) {
			@Override
			public String getDesc() {
				return "正常业务异常";
			}
		},
		NO_PERMISSION(999) {
			@Override
			public String getDesc() {
				return "无权限操作";
			}
		},
		NO_AUTH(401) {
			@Override
			public String getDesc() {
				return "未登录";
			}
		},
		TOKEN_EXPIRE(503) {
			@Override
			public String getDesc() {
				return "Token过期";
			}
		};
		public Integer code;

		/** {@linkplain #code} */
		public Integer getCode() {
			return code;
		}

		public abstract String getDesc();

		/** {@linkplain #code} */
		public void setCode(Integer code) {
			this.code = code;
		}

		private CodeEnum(Integer code) {
			this.code = code;
		}

	}
}
