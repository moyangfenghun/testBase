package suanfa.number;

public class arryandarry {

	public static void main(String[] args) {
//		int[] a= {1,2,3};
//		int[] b= new int[5];
//		System.arraycopy(a, 0, b, 0, 2);
//		for (int i = 0; i < b.length; i++) {
//			System.out.println("b:"+b[i]);
//		}
//		for (int i = 0; i < a.length; i++) {
//			System.out.println("a:"+a[i]);
//		}
		///
		int[] at= {2,5,6,7},bt= {3,5,16,54};
		arryandarry fa=new arryandarry();
		fa.arrands(at, bt);
		System.out.println(fa.findMedianSortedArrays(at, bt));
	}
	
	/*
	 * 查找两个数组的中值
	 */
	public void arrands(int[] at,int[] bt) {
		int[] cf=new int[at.length+bt.length];
		for (int i = 0; i < cf.length; i++) {
			if(i<at.length) {
				cf[i]=at[i];
			}else {
				cf[i]=bt[i-at.length];
			}
		}
		for (int i = 0; i < cf.length; i++) {
			System.out.print(","+cf[i]);
		}
		System.out.print("\n");
		for (int i = 0; i <cf.length-1; i++) {
			for (int ii = 0; ii < cf.length-(1+i); ii++) {
				int ch=0;
				if(cf[ii]>cf[ii+1]) {
					ch=cf[ii];
					cf[ii]=cf[ii+1];
					cf[ii+1]=ch;
				}
			}
		}
		
		for (int i = 0; i < cf.length; i++) {
			System.out.print(cf[i]+",");
		}
		
		if(cf.length%2==0) {
			System.out.println("中卫数:"+1.0*(cf[cf.length/2-1]+cf[cf.length/2])/2);
		}else {
			System.out.println("中卫数:"+cf[(int) Math.round(1.0*cf.length/2)-1]);
		}
	}
	
	/**
	 * 时间复杂度log(m+n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length;
        int n = nums2.length;
        
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempLength = m;
            m = n;
            n = tempLength;
        }
        int imin=0;int imax=m;
        
        int halfLength = (m + n + 1) / 2;
        System.out.println("halflength:"+halfLength);
        
        
        while (imin <= imax) {
            int i = (imin+imax)/2;
            int j = halfLength - i;
            
            if (i<imax && nums1[i] < nums2[j-1]) {
                imin= i + 1;
            } else if (i > imin && nums1[i-1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxLeft =0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } else {
                    int minRight =0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums2[j], nums1[i]);
                    }
                    return (maxLeft+minRight)/2.0;
                }
            }
        }

        return 0.0;
    }

}
