package WEEK1.Algorithms_DS.exercise2;

class ProductItem {
    String productId;
    String productName;
    String category;

    public ProductItem(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class SearchSystem {
    public ProductItem linearSearch(ProductItem[] products, String targetId) {
        for (ProductItem product : products) {
            if (product.productId.equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    public ProductItem binarySearch(ProductItem[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productId.compareTo(targetId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
