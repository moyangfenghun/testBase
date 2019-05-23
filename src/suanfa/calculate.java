package yers.test.suanfa.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 字符、数组算法
 */
public class calculate {

	/**
	 * 找出字符传中最长一个回文子串
	 */
	public String longestPalindrome(String s) {
		int n = s.length(), b = 0, d = 0, ans = 0;
		if (n <= 1)
			return s;
		for (int z = 0; z < n; z++) {
			for (int i = z, j = z; i >= 0 && j < n && s.charAt(i) == s.charAt(j);) {
				if (j - i > ans) {
					ans = j - i;
					b = i;
					d = j;
				}
				i--;
				j++;
			}
			for (int i = z, j = z + 1; i >= 0 && j < n && s.charAt(i) == s.charAt(j);) {
				if (j - i > ans) {
					ans = j - i;
					b = i;
					d = j;
				}
				i--;
				j++;
			}

		}
		return s.substring(b, d + 1);
	}

	/**
	 * 找出字符串中不重复的最长子串大小
	 */
	public int lengthOfLongestSubstring(String s) {

		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();

		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		System.out.println(ans);
		return ans;
	}

	/**
	 * 倒N型排列字符串
	 */
	public String convert(String s, int numRows) {
		int i = 2 * numRows - 2;// 3
		StringBuilder newsss = new StringBuilder();
		if (i == 0)
			return s;
		for (int j2 = 0; j2 < numRows; j2++) {
			for (int j = 0; j2 + i * j < s.length(); j++) {
				newsss.append(s.charAt(j2 + i * j));
				if (j2 != 0 && j2 != (numRows - 1) && (j2 + i * j + (numRows - 1 - j2) * 2) < s.length()) {
					newsss.append(s.charAt(j2 + i * j + (numRows - 1 - j2) * 2));
				}
			}
		}
		return newsss.toString();
	}

	/**
	 * 翻转数字
	 */
	public int reverse(int x) {
		int fax = 0;
		while (x != 0) {
			// 翻转判断是否溢出
			if (fax > Integer.MAX_VALUE / 10) {
				return 0;
			}
			if (fax < Integer.MIN_VALUE / 10) {
				return 0;
			}
			fax = fax * 10 + x % 10;
			x = x / 10;
		}
		// 翻转...
		return fax;
	}

	/**
	 * 将字符串中第一个整数字符子串转化为整数,正则表达式版
	 */
	public int myAtoi(String str) {
		String regex = "^\\s*(((?:-|\\+){0,1})(\\d+)).*$";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(str);
		String rs = "";
		String rss = "";
		String fh = "";
		if (m.matches()) {
			System.out.println(m.group());
			System.out.println(rs = m.group(1));
			System.out.println(fh = m.group(2));
			System.out.println(rss = m.group(3));
		} else {
			return 0;
		}
		if (rss.length() > 10) {
			if ("-".equals(fh)) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		if (rss.length() == 10) {
			Integer ina = Integer.valueOf(rss.substring(0, rss.length() - 1));
			Integer inls = Integer.valueOf(rss.substring(rss.length() - 1, rss.length()));
			if (!"-".equals(fh)) {
				if (ina > Integer.MAX_VALUE / 10 || (ina == Integer.MAX_VALUE / 10 && inls > 7)) {
					return Integer.MAX_VALUE;
				}
			} else {
				if (ina > Integer.MAX_VALUE / 10 || (ina == Integer.MAX_VALUE / 10 && inls > 8)) {
					return Integer.MIN_VALUE;
				}
			}
		}
		return Integer.valueOf(rs);
	}

	/**
	 * 将字符串中第一个整数字符子串转化为整数 空格 32,48-57,45-,43+
	 */
	public int myAtoi2(String str) {
		byte[] bytes = str.getBytes();
		String sis = "";
		String wufuhaosis = "";
		String fuhao = "";
		boolean s = true, zf = true;
		for (int i = 0; i < str.length(); i++) {
			if (bytes[i] == 32) {
				if (!s || !zf) {
					break;
				}
			} else if (s && zf && (bytes[i] == 45 || bytes[i] == 43)) {
				zf = false;
				sis += str.charAt(i);
				fuhao = "" + str.charAt(i);
			} else if (bytes[i] >= 48 && bytes[i] <= 57) {
				if (wufuhaosis != "") {
					Integer ina = Integer.valueOf(wufuhaosis);
					int inls = Integer.valueOf(str.charAt(i) + "");

					if (!"-".equals(fuhao)) {
						if (ina > Integer.MAX_VALUE / 10 || (ina == Integer.MAX_VALUE / 10 && inls > 7)) {
							System.out.println(ina + "xx" + inls);
							return Integer.MAX_VALUE;
						}
					} else {
						if (ina > Integer.MAX_VALUE / 10 || (ina == Integer.MAX_VALUE / 10 && inls > 8)) {
							return Integer.MIN_VALUE;
						}
					}
				}
				sis += str.charAt(i);
				wufuhaosis += str.charAt(i);
				s = false;
			} else {
				break;
			}
		}
		if (s)
			return 0;

		return Integer.valueOf(sis);
	}

	/**
	 * 自定义正则表达式a-z . *
	 */
	public boolean isMatch(String s, String p) {
		// aa ,az ,., .* ,a*.,a*, a*ssc*kl.=aaaasccdk==ackc=ssckk=ssckl

		String sf = "", suf = "";
		String a = "", b = "", c = "";
		if (!p.contains("*") && !p.contains(".")) {
			return p.equals(s);
		}

		return false;

	}

	/**
	 * 盛最多水的容器
	 */
	public int maxArea(int[] height) {
		int a = 0;
		int b = height.length - 1;
		int l = 0, min = 0;
		int maxarea = 0;
		for (; a < b;) {
			if (l == 2) {
				if (min > height[a]) {
					a++;
					continue;
				}
			} else if (l == 1) {
				if (min > height[b]) {
					b--;
					continue;
				}
			}
			min = Math.min(height[a], height[b]);
			maxarea = Math.max(maxarea, Math.min(height[a], height[b]) * (b - a));
			if (height[a] > height[b]) {
				b--;
				l = 1;
			} else {
				a++;
				l = 2;
			}

		}
		return maxarea;
	}

	/**
	 * 最长公共前缀
	 */
	public String longestCommonPref(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		System.out.println(prefix);
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
				System.out.println(prefix);
			}
		}
		return prefix;
	}
}
