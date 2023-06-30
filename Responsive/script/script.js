let list = [];
let products = document.querySelector(".product-grid");
let numperpage = 12; // number of items in a page

let calPrice = (cost, discount) => cost - (cost * discount) / 100;

let getListByPage = (list, start, end) => {
  tmp = [];
  for (let i = start; i < end; i++) {
    tmp.push(list[i]);
  }
  return tmp;
};

/***************************************************************/
fetch("/api_shoes_store/product")
  .then((response) => {
    console.log(response);
    if (!response.ok) throw new Error(`Request failed`);
    return response.json();
  })
  .then((data) => {
    const keys = Object.keys(data);

    keys.forEach((key) => {
      list.push(data[key]);
    });

    let pageSelected = 1;
    let size = list.length;
    let num =
      size % numperpage == 0 ? size / numperpage : size / numperpage + 1;
    let start = (pageSelected - 1) * numperpage;
    let end = Math.min(pageSelected * numperpage, size);

    const new_list = getListByPage(list, start, end);

    for (let i = 1; i < num; i++) {
      let html = `<div class="page-select-item" page="${i}">
                    <a class="page-select-link" page="${i}" href="tmp.html">${i}</a>
                </div>`;
      document
        .querySelector(".page-menu")
        .insertAdjacentHTML("beforeend", html);
    }

    document
      .querySelector(`.page-select-item[page="${pageSelected}"]`)
      .classList.add("active");
    document
      .querySelector(`.page-select-link[page="${pageSelected}"]`)
      .setAttribute("selected", "");

    new_list.forEach((obj) => {
      let html = `<div class="product-item"
						onclick="window.location.href = 'detail?id=${obj.key}'">
						<div class="discount">-${obj.discount}%</div>
						<img class="product-img" src="img/products_img/${obj.image}"
							alt="product_image">

						<p class="product-name">${obj.name}|${obj.id}</p>
						<span class="product-price"> ${new Intl.NumberFormat(["ban", "id"]).format(
              calPrice(obj.cost, obj.discount)
            )} đ
						</span><br> <span class="product-cost">${new Intl.NumberFormat([
              "ban",
              "id",
            ]).format(obj.cost)} đ</span> <span><i
							class="fas fa-eye item-hover"></i></span>
					</div>`;
      products.insertAdjacentHTML("beforeend", html);
    });

    // document.querySelectorAll(".page-select-link").forEach((btn) => {
    //   btn.addEventListener("click", function (e) {
    //     e.preventDefault();

    //     let pageSelected = parseInt(btn.getAttribute("page"));
    //     console.log(pageSelected);
    //     let size = list.length;
    //     let start = (pageSelected - 1) * numperpage;
    //     let end = Math.min(pageSelected * numperpage, size);

    //     const new_list = getListByPage(list, start, end);

    //     document
    //       .querySelector(".page-select-item.active")
    //       .classList.remove("active");

    //     document
    //       .querySelector(".page-select-link[selected]")
    //       .removeAttribute("selected");

    //     document
    //       .querySelector(`.page-select-item[page="${pageSelected}"]`)
    //       .classList.add("active");

    //     document
    //       .querySelector(`.page-select-link[page="${pageSelected}"]`)
    //       .setAttribute("selected", "");

    //     products.innerHTML = "";

    //     new_list.forEach((obj) => {
    //       let html = `<div class="product-item"
    //                                 onclick="window.location.href = 'detail?id=${
    //                                   obj.key
    //                                 }'">
    //                                 <div class="discount">-${
    //                                   obj.discount
    //                                 }%</div>
    //                                 <img class="product-img" src="img/products_img/${
    //                                   obj.image
    //                                 }"
    //                                     alt="product_image">

    //                                 <p class="product-name">${obj.name}|${
    //         obj.id
    //       }</p>
    //                                 <span class="product-price"> ${new Intl.NumberFormat(
    //                                   ["ban", "id"]
    //                                 ).format(
    //                                   calPrice(obj.cost, obj.discount)
    //                                 )} đ
    //                                 </span><br> <span class="product-cost">${new Intl.NumberFormat(
    //                                   ["ban", "id"]
    //                                 ).format(obj.cost)} đ</span> <span><i
    //                                     class="fas fa-eye item-hover"></i></span>
    //                             </div>`;

    //       products.insertAdjacentHTML("beforeend", html);
    //     });
    //   });
    // });
  })
  .catch((err) => {
    (err) => console.log(err);
  });

// EventListener
document
  .querySelector(".confirm-checkout")
  .addEventListener("click", function () {
    //onclick="window.location.href='orders'"
    let inp = document.querySelector('input[name="recepient"]').value;
    window.location.href = `orders?recepient=${inp}`;
  });

//const list=[];
fetch("/shoes_store_dashboard/product")
  .then((response) => {
    console.log(response);
    if (!response.ok) throw new Error(`Request failed`);
    return response.json();
  })
  .then((data) => {
    const keys = Object.keys(data);

    keys.forEach((key) => {
      list.push(data[key]);
    });

    for (p of list) {
      let html =
        "<tr><td>" +
        p["id"] +
        "</td><td>" +
        p["name"] +
        "</td><td>" +
        p["cost"] +
        "</td><td>" +
        p["discount"] +
        '</td><td><img src="data:image/jpg;base64,' +
        p["image"] +
        '" alt=""></td><td><img src="data:image/jpg;base64,' +
        p["imageDetail"] +
        '" alt=""></td><td>' +
        p["brandId"] +
        '</td><td><a href="productDAO?command=delete&id=' +
        p["id"] +
        '" onclick="if (!(confirm(\'Are you sure you want to delete this product?\'))) return false">XÓA</a><span>|</span> <a href="productDAO?command=load&id=' +
        p["id"] +
        '">SỬA</a></td></tr>';

      document.querySelector(".products").insertAdjacentHTML("beforeend", html);
    }
  });
